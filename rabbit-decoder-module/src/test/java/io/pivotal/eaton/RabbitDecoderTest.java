package io.pivotal.eaton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Simple tests for the rabbit decoder module
 * 
 * @author Brian Jimerson
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:rabbit-decoder-test.xml"})
public class RabbitDecoderTest {
	
	@Autowired
	AmqpAdmin amqpAdmin;
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	/**
	 * Simple test that puts a binary message on an RMQ queue.
	 */
	@Test
	public void testDecoding() {
		
		amqpAdmin.declareQueue(new Queue("eaton"));
		File file = new File("/Users/brian/Downloads/1.data");
		FileInputStream inputStream = null;
		byte[] bytes = new byte[(int) file.length()];
		try {
			inputStream = new FileInputStream(file);
			inputStream.read(bytes);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.toString());
		}
		Message message = new Message(bytes, new MessageProperties());
		amqpTemplate.send(message);
		
	}

}
