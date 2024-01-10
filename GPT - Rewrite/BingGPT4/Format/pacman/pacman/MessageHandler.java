package com.yeshj.pacman.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.dao.ITaskDAO;
import com.yeshj.pacman.jms.IMQListener;
import com.yeshj.pacman.jms.message.FeedbackMessage;
import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import com.yeshj.pacman.model.TaskModel;
import com.yeshj.pacman.utils.DateHelper;
import com.yeshj.pacman.utils.WebHelper;
import com.yeshj.pacman.utils.Wrapper;

public class MessageHandler implements IMQListener {

	private static final ILog logger = LogFactory.getLog(MessageHandler.class);
	private final ITaskDAO taskDAO;

	public MessageHandler(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public void onMessage(Message arg0) {
		// No implementation needed
	}

	@Override
	public void onTextMessage(String msg) {
		// No implementation needed
	}

	@Override
	public void onStreamMessage(byte[] buffer) {
		// No implementation needed
	}

	@Override
	public void onMapMessage(Map<String, Object> map) {
		// No implementation needed
	}

	@Override
	public void onObjectMessage(Object obj) {
		if (obj instanceof FeedbackMessage) {
			FeedbackMessage feedbackMessage = (FeedbackMessage) obj;
			handleFeedbackMessage(feedbackMessage);
		}
	}

	private void handleFeedbackMessage(FeedbackMessage feedbackMessage) {
		try {
			TaskModel task = taskDAO.findByPk(feedbackMessage.getCommandId());
			String url = getCallbackUrl(task);
			ArrayList<NameValuePair> data = prepareCallbackData(task, feedbackMessage, url);
			updateTaskStatus(feedbackMessage, task, url, data);
		} catch (Exception e) {
			logger.error("Fail to save task callback status.", e);
		}
	}

	private String getCallbackUrl(TaskModel task) {
		if (1 == task.getType()) {
			return AppConfig.getInstance().getOcsCallbackUrl();
		} else {
			return AppConfig.getInstance().getTransCallbackUrl();
		}
	}

	private ArrayList<NameValuePair> prepareCallbackData(TaskModel task, FeedbackMessage feedbackMessage, String url) {
		ArrayList<NameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("lessonid", task.getLid().toString()));
		data.add(new BasicNameValuePair("taskid", task.getTid().toString()));
		data.add(new BasicNameValuePair("stat", feedbackMessage.isSuccess() ? "2" : "3"));
		return data;
	}

	private void updateTaskStatus(FeedbackMessage feedbackMessage, TaskModel task, String url,
			ArrayList<NameValuePair> data) {
		Wrapper<String> content = new Wrapper<>();
		boolean callOcsOk = WebHelper.postUrl(url, data, content);
		Map<String, Object> map = new HashMap<>();
		map.put("end", DateHelper.getCurrentTime());
		map.put("status", feedbackMessage.isSuccess() ? 2 : 3);
		map.put("err", callOcsOk ? feedbackMessage.getMsg() : "CALLBACK FAIL, " + feedbackMessage.getMsg());
		map.put("modified", DateHelper.getCurrentTime());
		taskDAO.update(feedbackMessage.getCommandId(), map);
		logger.warn("callback url:" + url + " ret:" + callOcsOk);
	}
}
