package Receive;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Receiver implements MessageListener {
	private Session session = null;
	private MessageConsumer consumer = null;

	public String receive() {
		try {
			Context initContext = new InitialContext();
			Context webContext = (Context) initContext.lookup("java:/comp/env");
			TopicConnectionFactory activeMQConnectionFactory = (TopicConnectionFactory) webContext.lookup("ConnectionFactory");
			Connection connection = activeMQConnectionFactory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = (Queue) webContext.lookup("receiver");
			consumer = session.createConsumer(queue);
			Message message = consumer.receive();
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			System.out.println(text);
			connection.close();
			return text;
		} catch (JMSException | NamingException e) {
			System.out.println("Erreur");
			return null;
		}
	}

	@Override
	public void onMessage(Message arg0) {
		receive();
	}
}
