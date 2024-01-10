/******************************************************************
 * Copyright © 2015 hujiang.com. All rights reserved.
 *
 * @Title: Wrapper.java
 * @Prject: libCommon
 * @Package: com.yeshj.pacman.utils
 * @Description: packing and transcoding classware of hujiang.com.
 *                http://class.hujiang.com/
 * @author: Dellinger
 * @date: 2015年1月4日 下午11:49:26
 * @version: V1.0
 ******************************************************************/

package com.yeshj.pacman.utils;

public class Wrapper<T> {

	private T data;

	private boolean isEmpty;

	public T getData() {
		return data;
	}

	public void setData(T data) {

		this.data = data;
		isEmpty = this.data == null;
	}

	public boolean isEmpty() {

		return isEmpty;
	}
}
