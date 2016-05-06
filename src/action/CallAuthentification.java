package action;

import java.io.IOException;
import java.util.concurrent.Callable;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import Receive.Decodeur;
import Receive.Receiver;
import Schema.Command;
import Send.Encodeur;
import Send.Sender;
import model.Authentifier;
import model.CreerCompte;

public class CallAuthentification implements Callable<Integer> {
	private Receiver r = new Receiver();
	private Decodeur d = new Decodeur();
	private Sender s = new Sender();
	private Encodeur e = new Encodeur();
	private String login;
	private Context ctx;
	private String mdp;

	public CallAuthentification(String login,String mdp, Context ctx) {
		super();
		this.login = login;
		this.ctx = ctx;
		this.mdp = mdp;
	}
	/*
	public int demandeAuthentification(String login, String mdp, Context ctx) {
		try {
			Authentifier auth = new Authentifier();
			auth.setLogin(login);
			auth.setPass(mdp);
			Command c = auth;
			String leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.authentification();
		} catch (JAXBException | NamingException | IOException | JMSException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	*/
	
	@Override
	public Integer call() throws Exception {
		try {
			Authentifier auth = new Authentifier();
			auth.setLogin(login);
			auth.setPass(mdp);
			Command c = auth;
			String leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.authentification();
		} catch (JAXBException | NamingException | IOException | JMSException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

}
