package Receive;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import javax.jms.JMSException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import Schema.Command;

public class Decodeur {
	public Command unmarshal(String message) throws JAXBException, IOException, JMSException, XMLStreamException {
		JAXBContext jaxbContext = JAXBContext.newInstance(MyProperties.getProperty("class_package"));
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Reader reader = new StringReader(message);
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader xmlReader = factory.createXMLStreamReader(reader);
		Command command = (Command) jaxbUnmarshaller.unmarshal(xmlReader);
		return command;
	}
}