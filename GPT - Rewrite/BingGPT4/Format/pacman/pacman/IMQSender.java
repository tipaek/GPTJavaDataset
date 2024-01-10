package com.yeshj.pacman.jms;

import java.util.Map;

public interface IMQSender {

	/**
	 * Sends a text format message.
	 *
	 * @param msg the message to send
	 * @throws MQException if an error occurs
	 */
	void sendTextMessage(String msg) throws MQException;

	/**
	 * Sends text format messages one by one.
	 *
	 * @param msgs the messages to send
	 * @throws MQException if an error occurs
	 */
	void sendTextMessage(String[] msgs) throws MQException;

	/**
	 * Sends key-value data.
	 *
	 * @param map the map to send
	 * @throws MQException if an error occurs
	 */
	void sendMapMessage(Map<String, Object> map) throws MQException;

	/**
	 * Sends an object via the class of the object.
	 *
	 * @param t the object to send
	 * @throws MQException if an error occurs
	 */
	<T> void sendObject(T t) throws MQException;

	/**
	 * Sends a byte stream.
	 *
	 * @param buffer the byte stream to send
	 * @throws MQException if an error occurs
	 */
	void sendStream(byte[] buffer) throws MQException;

	/**
	 * Gets the destination (Queue name or Topic name).
	 *
	 * @return the destination
	 */
	String getDestName();

	/**
	 * Determines if sending to a queue or topic.
	 *
	 * @return true if sending to a queue, false otherwise
	 */
	boolean isQueue();

	/**
	 * Closes the connection.
	 *
	 * @throws MQException if an error occurs
	 */
	void close() throws MQException;
}
