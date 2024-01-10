package com.yeshj.pacman.utils;

import java.lang.reflect.Field;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.lang3.ArrayUtils;

import com.yeshj.pacman.annotation.Transmit;

public class MessageHelper {

	public static <T> T getObjectMessage(MapMessage map) throws Exception {
		String className = map.getStringProperty("mq.clazz");
		Class<?> clazz = Class.forName(className);
		Field[] fields = clazz.getDeclaredFields();
		if (Object.class != clazz.getSuperclass()) {
			fields = ArrayUtils.addAll(fields, clazz.getSuperclass().getDeclaredFields());
		}
		Object obj = clazz.newInstance();

		for (Field field : fields) {
			Transmit transmit = field.getAnnotation(Transmit.class);
			if (transmit != null) {
				field.setAccessible(true);
				field.set(obj, map.getObject(transmit.key()));
			}
		}

		return (T) obj;
	}

	public static String getStringMessage(Message message) throws JMSException {
		if (message instanceof TextMessage) {
			return ((TextMessage) message).getText();
		}
		return null;
	}
}
