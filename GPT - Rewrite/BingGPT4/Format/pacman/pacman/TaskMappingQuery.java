/******************************************************************
 * Copyright © 2015 hujiang.com. All rights reserved.
 *
 * @Title: TaskMappingQuery.java
 * @Prject: pacman
 * @Package: com.yeshj.pacman.dao.impl
 * @Description: packing and transcoding classware of hujiang.com.
 *                http://class.hujiang.com/
 * @author: Dellinger
 * @date: 2015年1月9日 上午3:33:27
 * @version: V1.0
 ******************************************************************/

package com.yeshj.pacman.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.yeshj.pacman.model.TaskModel;

public class TaskMappingQuery extends MappingSqlQuery<TaskModel> {

	@Override
	protected TaskModel mapRow(ResultSet resultSet, int rowNumber) throws SQLException {

		TaskModel taskModel = new TaskModel();
		taskModel.setTid(resultSet.getInt("tid"));
		taskModel.setCid(resultSet.getInt("cid"));
		taskModel.setLid(resultSet.getInt("lid"));
		taskModel.setGuid(resultSet.getString("guid"));
		taskModel.setFile(resultSet.getString("file"));
		taskModel.setBegin(resultSet.getTimestamp("begin"));
		taskModel.setEnd(resultSet.getTimestamp("end"));
		taskModel.setType(resultSet.getInt("type"));
		taskModel.setStatus(resultSet.getInt("status"));
		taskModel.setErr(resultSet.getString("err"));
		return taskModel;
	}
}
