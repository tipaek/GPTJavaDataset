package com.yeshj.pacman.jms;

import javax.jms.MessageListener;
import java.util.Map;

public interface IMQListener extends MessageListener {

	/**
	 * Handles a text message arrival event.
	 *
	 * @param msg the text message
	 */
	void onTextMessage(String msg);

	/**
	 * Handles a stream message arrival event.
	 *
	 * @param buffer the stream message
	 */
	void onStreamMessage(byte[] buffer);

	/**
	 * Handles a map message arrival event.
	 *
	 * @param map the map message
	 */
	void onMapMessage(Map<String, Object> map);

	/**
	 * Handles a generic object arrival event.
	 *
	 * @param obj the object message
	 */
	void onObjectMessage(Object obj);
}
