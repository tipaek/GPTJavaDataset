/********************************************************
 * Copyright © 2015 HuJiang.com. All rights reserved.
 *
 * @Title: TaskModel.java
 * @Prject: pacman
 * @Package: com.yeshj.pacman.model
 * @Description: packing and transcoding the classware of hujiang.com.
 *                 http://class.hujiang.com
 *
 * @author: zhangxinyu
 * @date: 2015年1月8日 下午4:32:46
 * @version: V1.0
 ********************************************************/
package com.yeshj.pacman.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class TaskModel implements Serializable {

	private static final long serialVersionUID = -1759501103L;
	private Integer taskId;
	private Integer classId;
	private Integer lessonId;
	private String file;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer taskType;
	private Integer taskStatus;
	private String error;
	private String guid;
	private boolean isFree;

	public TaskModel() {
		super();
	}

	public TaskModel(
			Integer taskId,
			Integer classId,
			Integer lessonId,
			String guid,
			String file,
			Timestamp startTime,
			Timestamp endTime,
			Integer taskType,
			Integer taskStatus,
			String error,
			boolean isFree) {

		super();
		this.taskId = taskId;
		this.classId = classId;
		this.lessonId = lessonId;
		this.file = file;
		this.startTime = startTime;
		this.endTime = endTime;
		this.taskType = taskType;
		this.taskStatus = taskStatus;
		this.error = error;
		this.guid = guid;
		this.isFree = isFree;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getLessonId() {
		return this.lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
