package com.yeshj.pacman.task.test;

import com.yeshj.pacman.schedule.IStep;
import com.yeshj.pacman.schedule.impl.DefaultWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class ComponentsTest {

    private BeanFactory factory;

    @Before
    public void setUp() {
        factory = new ClassPathXmlApplicationContext("schedules.xml");
    }

    @After
    public void tearDown() {
        // Add any cleanup code if necessary
    }

    @Test
    public void testIOCLoad() {
        DefaultWorker worker = (DefaultWorker) factory.getBean("complex");
        assertNotNull(worker);
        worker.getSteps().forEach(Assert::assertNotNull);
    }
}
