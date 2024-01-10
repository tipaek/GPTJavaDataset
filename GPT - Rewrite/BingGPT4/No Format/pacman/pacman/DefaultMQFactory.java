package com.yeshj.pacman.jms.impl;

import com.yeshj.pacman.jms.*;
import com.yeshj.pacman.log.ILog;
import com.yeshj.pacman.log.LogFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.util.InetAddressUtil;

import javax.jms.*;
import java.net.UnknownHostException;
import java.util.Map;

public class DefaultMQFactory implements IMQFactory {

    private static final ILog logger = LogFactory.getLog(DefaultMQFactory.class);
    private static final String PREFIX = "[MQFactory]";
    private static String clientID = null;

    private final ActiveMQConnectionFactory mFactory;
    private final Map<QueueType, String> map;

    private TopicConnection topicConnection;
    private TopicSession topicSession;
    private TopicSubscriber subscriber;

    public DefaultMQFactory(String addr, Map<QueueType, String> map) {
        if (clientID == null) {
            try {
                clientID = InetAddressUtil.getLocalHostName();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        this.map = map;
        mFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                addr);

        logger.info(PREFIX + " CREATED, addr:" + addr);
    }

    @Override
    public IMQSender getSender(QueueType qtype) throws MQException {
        String destName = map.get(qtype);

        try {
            Connection con = mFactory.createConnection();
            con.start();
            IMQSender sender;

            if (qtype == QueueType.TOPIC_COMMAND)
                sender = new DefaultMQSender(con, destName, false); //topic sender.
            else
                sender = new DefaultMQSender(con, destName);

            logger.info(PREFIX + " Sender created![" + destName + "]");

            return sender;
        } catch (JMSException e) {
            throw new MQException("Can not getSender.", e);
        }
    }

    @Override
    public IMQReceiver getReceiver(QueueType qtype) throws MQException {
        String destName = map.get(qtype);

        try {
            Connection con = mFactory.createConnection();
            con.start();
            return new DefaultMQReceiver(con, destName);
        } catch (JMSException e) {
            throw new MQException("Fail to get receiver!", e);
        }
    }

    @Override
    public void setTopicListener(QueueType qtype, IMQListener listener) throws MQException {
        // Implementation goes here...
    }
}
