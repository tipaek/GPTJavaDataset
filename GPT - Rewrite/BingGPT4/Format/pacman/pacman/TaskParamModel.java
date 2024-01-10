/********************************************************
 * Copyright © 2015 HuJiang.com. All rights reserved.
 *
 * @Title: TaskParamModel.java
 * @Prject: pacman
 * @Package: com.yeshj.pacman.model
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2015年1月8日 下午4:33:43
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.model;

import java.io.Serializable;

public class TaskParamModel implements Serializable {

	private static final long serialVersionUID = -1177954821L;
	private Integer paramId;
	private Integer taskId;
	private String paramName;
	private String paramValue;

	public TaskParamModel() {
		super();
	}

	public TaskParamModel(
			Integer paramId,
			Integer taskId,
			String paramName,
			String paramValue) {

		super();
		this.paramId = paramId;
		this.taskId = taskId;
		this.paramName = paramName;
		this.paramValue = paramValue;
	}

	public Integer getParamId() {
		return this.paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (this.getClass() != otherObject.getClass())
			return false;
		TaskParamModel other = (TaskParamModel) otherObject;
		return this.paramId.equals(other.paramId)
				&& this.taskId.equals(other.taskId)
				&& this.paramName.equals(other.paramName)
				&& this.paramValue.equals(other.paramValue);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.paramId != null ? this.paramId.hashCode() : 0);
		hash += (this.taskId != null ? this.taskId.hashCode() : 0);
		hash += (this.paramName != null ? this.paramName.hashCode() : 0);
		hash += (this.paramValue != null ? this.paramValue.hashCode() : 0);
		return hash;
	}
}
