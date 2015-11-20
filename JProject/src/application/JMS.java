package application;

import javax.naming.*;
import javax.jms.*;



class StockListener implements MessageListener {

public void onMessage(Message message) {
	// Unpack and handle the messages received
	String newStockData =
	((TextMessage)message).getText();
	if(...) {
	// Logic related to the data
	}
	}

}

public class JMS {
	
	Context namingContext = new InitialContext();
	ConnectionFactory ConnectionFactory = (ConnectionFactory) namingContext.lookup("myCF");
	
	Queue stockQueue = (Queue)namingContext.lookup("StockSource");
	Connection connection = connectionFactory.createConnection();
	
	
	// Look up connection factory
	Context namingContext = new InitialContext();
	ConnectionFactory connectionFactory = (ConnectionFactory) namingContext.lookup("ConnectionFactory")
	// Look up destination
	Topic newsFeedTopic = namingContext.lookup("BreakingNews");
	// Create connection and session
	Connection connection = ConnectionFactory.createConnection();
	Session session=connection.createSession(Session.AUTO_ACKNOWLEDGE);
	
	MessageConsumer consumer = session.createDurableConsumer(newsFeedTopic,"mySubscription");

	// Session is not transacted and
	// uses AUTO_ACKNOWLEDGE for message acknowledgement
	Session session=connection.createSession(Session.AUTO_ACKNOWLEDGE);
	
	// stockQueue was previously looked up using JNDI
	MessageProducer producer = session.createProducer(stockQueue);
	
	// stockQueue was previously looked up using JNDI
	MessageConsumer consumer = session.createConsumer(stockQueue);
	
	
	String selector = new String("(StockSector = 'Technology')");
	MessageConsumer consumer = session.createConsumer(stockQueue,selector);
	
	
	
	connection.start();
	
	String stockData; // Stock information as a string
	// Set the message's text to be the stockData string
	TextMessage message = session.createTextMessage();
	message.setText(stockData);
			
	// Set the message property "StockSector"
	message.setStringProperty("StockSector", "Technology");
	
			// Send the message
			producer.send(message);
			
			// Wait up to 4 seconds for a message
			Message stockMessage = receiver.receive(4000);
			
			// extract stock information from message
			String newStockData = ((TextMessage)stockMessage)getText();
			
			// extract stock information from message
			String newStockData= stockMessage.getBody(String.class);
			
			
			StockListener myListener = new StockListener(); 
			// consumer is a MessageConsumer object 
			consumer.setMessageListener(myListener);
}

