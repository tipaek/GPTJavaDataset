/******************************************************************
 * Copyright © 2015 hujiang.com. All rights reserved.
 *
 * @Title: WebHelper.java
 * @Prject: libCommon
 * @Package: com.yeshj.pacman.utils
 * @Description: packing and transcoding classware of hujiang.com.
 *                http://class.hujiang.com/
 * @author: Dellinger
 * @date: 2015年1月5日 上午12:59:28
 * @version: V1.0
 ******************************************************************/

package com.yeshj.pacman.utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;

public final class WebHelper {

	private final static ILog logger = LogFactory.getLog(WebHelper.class);

	public static boolean isWebResource(String resource) {

		boolean isWebResource = false;
		if (!StringUtils.isEmpty(resource)) {

			isWebResource = resource.startsWith("http") || resource.startsWith("ftp");
		}
		return isWebResource;
	}

	public static boolean download(String url, String localFile) {

		boolean isDownloadSuccessful = true;
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		HttpGet getMethod = null;
		FileOutputStream output = null;

		try {

			FileHelper.ensureExists(localFile, true);
			output = new FileOutputStream(localFile);
			client = HttpClients.createDefault();
			getMethod = new HttpGet(url);

			response = client.execute(getMethod);
			if (response != null) {

				if (response.getStatusLine().getStatusCode() == 200) {

					IOUtils.copy(response.getEntity().getContent(), output);

				} else {

					logger.error(
							"Fail to download[" + url + "], http status:" + response.getStatusLine().getStatusCode());
				}

				response.close();
			} else {

				logger.error("Fail to download[" + url + "], response is null.");
			}

		} catch (Exception e) {

			logger.error("Fail to download[" + url + "]", e);
			isDownloadSuccessful = false;
		} finally {

			if (output != null) {
				try {
					output.flush();
					output.close();
				} catch (IOException e) {

					logger.error("Fail to close output.", e);
				}
			}

			if (client != null) {
				try {

					client.close();
				} catch (IOException e) {

					logger.error("Fail to close httpclient.", e);
				}
			}
		}

		return isDownloadSuccessful;
	}

	public static boolean loadUrl(String url, Wrapper<String> content) {

		boolean isLoadSuccessful = false;
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		HttpGet getMethod = null;
		BufferedReader reader = null;
		StringBuffer contentBuffer = new StringBuffer();

		try {

			client = HttpClients.createDefault();
			getMethod = new HttpGet(url);

			response = client.execute(getMethod);
			if (response != null) {

				if (response.getStatusLine().getStatusCode() == 200) {

					reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
					String line = null;
					while ((line = reader.readLine()) != null) {
						contentBuffer.append(line);
					}

					content.set(contentBuffer.toString());
					isLoadSuccessful = true;

				} else {

					logger.error("Fail to load[" + url + "], http status:" + response.getStatusLine().getStatusCode());
				}

				response.close();
			} else {

				logger.error("Fail to load[" + url + "], response is null.");
			}

		} catch (Exception e) {

			logger.error("Fail to load[" + url + "]", e);
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {

					logger.error("Fail to close reader.", e);
				}
			}

			if (client != null) {
				try {

					client.close();
				} catch (IOException e) {

					logger.error("Fail to close httpclient.", e);
				}
			}
		}

		return isLoadSuccessful;
	}
}
