package com.yeshj.pacman.jms.impl;

import com.yeshj.pacman.jms.IMQListener;
import com.yeshj.pacman.jms.IMQReceiver;
import com.yeshj.pacman.jms.MQException;

import javax.jms.*;

public class DefaultMQReceiver implements IMQReceiver {

    private final Connection mConnection;
    private final Session mSession;
    private final MessageConsumer mConsumer;
    private final Destination mDestination;

    private final boolean mIsQueue;
    private final MQEventSource mSource;

    protected DefaultMQReceiver(Connection connection, String destName) throws JMSException {
        this(connection, destName, true);
    }

    protected DefaultMQReceiver(Connection connection, String destName, boolean isQueue) throws JMSException {
        mConnection = connection;
        mIsQueue = isQueue;
        mSource = new MQEventSource();

        mSession = mConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        mDestination = mIsQueue ? mSession.createQueue(destName) : mSession.createTopic(destName);

        mConsumer = mSession.createConsumer(mDestination);
    }

    @Override
    public boolean tryGetMessage() throws MQException {
        return tryGetMessage(0);
    }

    @Override
    public boolean tryGetMessage(int milliseconds) throws MQException {
        boolean result;
        Message message;
        try {
            message = milliseconds < 10 ? mConsumer.receive(10) : mConsumer.receive(milliseconds);
            result = message != null;
        } catch (JMSException e) {
            throw new MQException("Fail to receive message!", e);
        }

        if (result) {
            mSource.fireMessageEvent(message);
        }

        return result;
    }

    @Override
    public void addListener(IMQListener listener) {
        mSource.addListener(listener);
    }

    @Override
    public String getDestName() {
        try {
            return mIsQueue ? ((Queue) mDestination).getQueueName() : ((Topic) mDestination).getTopicName();
        } catch (JMSException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public boolean isQueue() {
        return mIsQueue;
    }

    @Override
    public void Close() throws MQException {
        try {
            if (mSession != null) {
                mSession.close();
            }

            if (mConnection != null) {
                mConnection.close();
            }
        } catch (JMSException e) {
            throw new MQException("Failed to close connection or session!", e);
        }
    }
}
