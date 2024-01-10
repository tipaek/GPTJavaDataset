package com.yeshj.pacman.jms.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;

import org.springframework.context.ApplicationContextException;

import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.jms.IMQFactory;
import com.yeshj.pacman.jms.IMQListener;
import com.yeshj.pacman.jms.IMQReceiver;
import com.yeshj.pacman.jms.IMQSender;
import com.yeshj.pacman.jms.IMessageBuilder;
import com.yeshj.pacman.jms.IMessageManager;
import com.yeshj.pacman.jms.MQException;
import com.yeshj.pacman.jms.QueueType;
import com.yeshj.pacman.jms.message.BaseMessage;

public class MessageManager implements IMessageManager {

	private final IMQFactory mqFactory;

	public MessageManager() {
		this.mqFactory = createFactory();
	}

	@Override
	public <T extends BaseMessage> void sendMessage(T msg, QueueType dest) throws MQException {
		IMQSender sender = null;
		try {
			sender = mqFactory.getSender(dest);
			sender.sendObject(msg);
		} finally {
			if (sender != null) {
				sender.Close();
			}
		}
	}

	@Override
	public Message receiveMessage(QueueType dest) throws MQException {
		Message result = null;
		IMQReceiver receiver = null;
		try {
			receiver = mqFactory.getReceiver(dest);
			result = receiver.getMessage(AppConfig.getInstance().getJmsLoadTimeout());
		} finally {
			if (receiver != null) {
				receiver.Close();
			}
		}
		return result;
	}

	@Override
	public IMessageBuilder createBuilder() {
		return new DefaultMessageBuilder();
	}

	@Override
	public IMQFactory createFactory() {
		if (AppConfig.getInstance() == null) {
			throw new ApplicationContextException("AppConfig is null!");
		}

		Map<QueueType, String> map = new HashMap<>();
		map.put(QueueType.QUEUE_AUDIO, AppConfig.getInstance().getAudioQueueName());
		map.put(QueueType.QUEUE_VIDEO, AppConfig.getInstance().getVideoQueueName());
		map.put(QueueType.QUEUE_FEEDBACK, AppConfig.getInstance().getFeedbackQueueName());
		map.put(QueueType.QUEUE_HEARTBEAT, AppConfig.getInstance().getHeartbeatQueueName());
		map.put(QueueType.TOPIC_COMMAND, AppConfig.getInstance().getCommandTopicName());

		return new DefaultMQFactory(AppConfig.getInstance().getJmsAddress(), map);
	}

	@Override
	public void setMessageListener(IMQListener listener, QueueType dest) throws MQException {
		if (mqFactory != null) {
			if (dest == QueueType.TOPIC_COMMAND) {
				mqFactory.closeTopicListener();
				mqFactory.setTopicListener(dest, listener);
			} else {
				if (MessagePoller.getMessageManager() == null) {
					MessagePoller.setMessageManager(this);
				}
			}
		}
	}
}
