package com.yeshj.pacman.jms;

public interface IMQFactory {

	/**
	 * Gets the specified message queue sender.
	 *
	 * @param qtype the type of the queue
	 * @return the message queue sender
	 * @throws MQException if an error occurs
	 */
	IMQSender getSender(QueueType qtype) throws MQException;

	/**
	 * Gets the specified message queue receiver.
	 *
	 * @param qtype the type of the queue
	 * @return the message queue receiver
	 * @throws MQException if an error occurs
	 */
	IMQReceiver getReceiver(QueueType qtype) throws MQException;

	/**
	 * Sets the specified topic subscriber.
	 *
	 * @param qtype    the type of the queue
	 * @param listener the listener to set
	 * @throws MQException if an error occurs
	 */
	void setTopicListener(QueueType qtype, IMQListener listener) throws MQException;

	/**
	 * Closes the topic listener's connection.
	 *
	 * @throws MQException if an error occurs
	 */
	void closeTopicListener() throws MQException;
}
