
import java.net.URI;
import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.kaazing.gateway.jms.client.stomp.StompConnectionFactory;

public class Temp {
	
	private Car car = new Car();
	private Connection connection;
	private String url;
	
	public Temp() throws JMSException, URISyntaxException {
		
		StompConnectionFactory factory = new StompConnectionFactory(new URI(url));
		connection = factory.createConnection();
		connection.setExceptionListener(new ExceptionListener() {
			@Override
			public void onException(JMSException e) {
				System.out.println(e.toString());
			}
		});
		
	}
	
	public void Receive() throws JMSException {
		
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public static void main(String[] args) {

	}

}
