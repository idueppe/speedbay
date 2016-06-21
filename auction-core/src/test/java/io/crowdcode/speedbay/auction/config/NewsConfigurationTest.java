package io.crowdcode.speedbay.auction.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class NewsConfigurationTest {

    @Test
    public void testNewsPaperConfigurationWithXML() throws Exception {
        String location = "exercise-with-newspaper.xml";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);

        assertNotNull(context.getBean("newsPaper"));
    }

    @Test
    public void testNewsPaperConfigurationWithBean() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NewsConfiguration.class);

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        assertNotNull(context.getBean("newsPaper"));
    }
}