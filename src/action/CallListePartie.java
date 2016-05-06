package action;

import java.io.IOException;
import java.util.ArrayList;
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
import model.ListePartie;
import model.Partie;

public class CallListePartie implements Callable<ArrayList<Partie>> {
	private Receiver r = new Receiver();
	private Decodeur d = new Decodeur();
	private Sender s = new Sender();
	private Encodeur e = new Encodeur();
	private int login;
	private Context ctx;

	public CallListePartie(){
	}
	
	public CallListePartie(int login, Context ctx) {
		this.login = login;
		this.ctx = ctx;
	}
/*
	public ArrayList<Partie> demandeListePartie(int login, Context ctx) {
		try {
			ListePartie lp = new ListePartie();
			lp.setIdUser(login);
			Command c = lp;
			String leMessage;
			leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.listePartie();
		} catch (JAXBException | IOException | JMSException | XMLStreamException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public ArrayList<Partie> call() throws Exception {
		try {
			ListePartie lp = new ListePartie();
			lp.setIdUser(login);
			Command c = lp;
			String leMessage;
			leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.listePartie();
		} catch (JAXBException | IOException | JMSException | XMLStreamException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
