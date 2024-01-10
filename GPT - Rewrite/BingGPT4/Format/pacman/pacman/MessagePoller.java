package com.yeshj.pacman.jms.impl;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.yeshj.pacman.annotation.Transmit;
import com.yeshj.pacman.config.AppConfig;
import com.yeshj.pacman.jms.IMQListener;
import com.yeshj.pacman.jms.IMessageManager;
import com.yeshj.pacman.jms.MQException;
import com.yeshj.pacman.jms.QueueType;
import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;

public class MessagePoller extends TimerTask {

	private static final ILog logger = LogFactory.getLog(MessagePoller.class);
	private static final String PREFIX = "[MessagePoller]";
	private static final List<IMQListener> listeners = new ArrayList<>();
	private static IMessageManager messageManager = null;

	public static void addListener(IMQListener listener) {
		synchronized (listeners) {
			listeners.add(listener);
		}
	}

	public static void setMessageManager(IMessageManager mgr) {
		messageManager = mgr;
	}

	public static IMessageManager getMessageManager() {
		return messageManager;
	}

	@Override
	public void run() {
		if (messageManager == null) {
			return;
		}
		try {
			Message msg = messageManager.receiveMessage(QueueType.QUEUE_FEEDBACK);
			if (msg != null) {
				fireMessageEvent(msg);
			}
		} catch (MQException e) {
			logger.error("receiver message error!", e);
		}
	}

	private void fireMessageEvent(Message message) throws MQException {
		int type = 0;
		String txt = null;
		byte[] buf = null;
		Map<String, Object> map = null;
		String className = null;

		try {
			if (message instanceof TextMessage) {
				type = 1;
				txt = ((TextMessage) message).getText();
				logger.info(PREFIX + " Got text message![" + txt + "]");
			} else if (message instanceof BytesMessage) {
				type = 2;
				BytesMessage bm = (BytesMessage) message;
				ByteBuffer bb = ByteBuffer.allocate((int) bm.getBodyLength());
				buf = bb.array();
				bm.readBytes(buf);
				logger.info(PREFIX + " Got stream message![" + bm.getJMSMessageID() + "]");
			} else if (message instanceof MapMessage) {
				className = message.getStringProperty("mq.clazz");
				if (StringUtils.isEmpty(className)) {
					type = 3;
				} else {
					type = 4;
				}
				map = new HashMap<>();
				MapMessage mm = ((MapMessage) message);
				Enumeration<?> en = mm.getMapNames();
				while (en.hasMoreElements()) {
					String key = (String) en.nextElement();
					map.put(key, mm.getObject(key));
				}
			}
		} catch (JMSException e) {
			throw new MQException("Fail to recognize the message type!", e);
		}

		synchronized (listeners) {
			for (IMQListener listener : listeners) {
				switch (type) {
					case 1:
						listener.onTextMessage(txt);
						break;
					case 2:
						listener.onStreamMessage(buf);
						break;
					case 3:
						listener.onMapMessage(map);
						break;
					case 4:
						// Handle the case when type is 4
						break;
					default:
						break;
				}
			}
		}
	}
}
