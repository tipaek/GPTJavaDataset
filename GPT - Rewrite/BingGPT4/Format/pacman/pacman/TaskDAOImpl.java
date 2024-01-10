/******************************************************************
 * Copyright © 2015 hujiang.com. All rights reserved.
 *
 * @Title: TaskDAOImpl.java
 * @Prject: pacman
 * @Package: com.yeshj.pacman.dao.impl
 * @Description: packing and transcoding classware of hujiang.com.
 *                http://class.hujiang.com/
 * @author: Dellinger
 * @date: 2015年1月9日 上午1:00:37
 * @version: V1.0
 ******************************************************************/

package com.yeshj.pacman.dao.impl;

import java.sql.Types;
import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlUpdate;

import com.yeshj.pacman.dao.ITaskDAO;
import com.yeshj.pacman.model.TaskModel;
import com.yeshj.pacman.utils.DateHelper;

public class TaskDAOImpl extends JdbcDaoSupport implements ITaskDAO {

	class TaskAdder extends SqlUpdate {

		public TaskAdder(DataSource dataSource) {
			setDataSource(dataSource);
			setSql("INSERT INTO task (tid, cid, lid, guid, type, file, begin, modified) VALUES(?, ?, ?, ?, ?, ?, now(), now())");
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			compile();
		}
	}

	class TaskSaver extends SqlUpdate {

		public TaskSaver(DataSource dataSource) {
			setDataSource(dataSource);
			setSql("UPDATE task SET cid=?, lid=?, guid=?, type=?, file=?, begin=?, end=?, status=?, err=?, modified=now() WHERE tid=?");
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.TIMESTAMP));
			declareParameter(new SqlParameter(Types.TIMESTAMP));
			declareParameter(new SqlParameter(Types.INTEGER));
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			compile();
		}
	}

	private TaskAdder taskAdder;
	private TaskSaver taskSaver;

	@Override
	public void add(TaskModel task) {

		if (taskAdder == null)
			taskAdder = new TaskAdder(getDataSource());

		taskAdder.update(task.getTid(), task.getCid(), task.getLid(), task.getGuid(), task.getType(), task.getFile());
	}

	@Override
	public void delete(TaskModel task) {

		String sql = "DELETE task WHERE tid=" + task.getTid();
		getJdbcTemplate().execute(sql);
	}

	@Override
	public void save(TaskModel task) {

		if (taskSaver == null)
			taskSaver = new TaskSaver(getDataSource());

		taskSaver.update(
				task.getCid(),
				task.getLid(),
				task.getGuid(),
				task.getType(),
				task.getFile(),
				DateHelper.getCurrentTime(),
				task.getEnd(),
				task.getStatus(),
				task.getErr(),
				task.getTid());
	}

	@Override
	public TaskModel findByPk(int taskId) {

		TaskMappingQuery query = new TaskMappingQuery();
		query.setDataSource(getDataSource());
		query.setSql("SELECT * FROM task WHERE tid=?");
		query.declareParameter(new SqlParameter(Types.INTEGER));
		query.compile();

		return query.findObject(taskId);
	}
}
