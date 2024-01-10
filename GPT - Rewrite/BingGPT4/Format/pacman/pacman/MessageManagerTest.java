package com.yeshj.pacman.jms.test;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yeshj.pacman.jms.IMessageManager;
import com.yeshj.pacman.jms.impl.MessageManager;

public class MessageManagerTest {

	private BeanFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("config.xml");
	}

	@After
	public void tearDown() {
		// Consider adding cleanup code here
	}

	@Test
	public void testManager() {
		MessageManager manager = (MessageManager) factory.getBean("mq.manager");
		assertNotNull(manager);
	}
}
