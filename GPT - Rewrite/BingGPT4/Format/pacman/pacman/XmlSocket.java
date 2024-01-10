/********************************************************
 * Copyright © 2014 HuJiang.com. All rights reserved.
 *
 * @Title: XmlSocket.java
 * @Prject: libTask
 * @Package: com.yeshj.pacman.schedule.dom
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2014年12月24日 下午6:06:42
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.schedule.dom;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class XmlSocket {

	private String urlStr = null;
	private SAXReader saxReader = new SAXReader();

	public XmlSocket(String urlStr) {
		this.urlStr = urlStr;
	}

	public Document connect() throws Exception {

		URL url = new URL(urlStr);
		return saxReader.read(url);
	}
}
