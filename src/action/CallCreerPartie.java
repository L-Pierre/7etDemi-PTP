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
import model.CreerPartie;
import model.Partie;

public class CallCreerPartie implements Callable<Partie> {
	private Receiver r = new Receiver();
	private Decodeur d = new Decodeur();
	private Sender s = new Sender();
	private Encodeur e = new Encodeur();
	private String nomPartie;
	private int nbJoueur;
	private int id_user;
	private Context ctx;
	
	public CallCreerPartie(String nomPartie, int nbJoueur, int id_user,Context ctx) {
		super();
		this.nomPartie = nomPartie;
		this.nbJoueur = nbJoueur;
		this.id_user = id_user;
		this.ctx=ctx;
	}
	
	public Partie call() throws Exception {
		try {
			CreerPartie p = new CreerPartie();
			p.setIdUser(id_user);
			p.setNomPartie(nomPartie);
			p.setMaxPlayer(nbJoueur);
			Command c = p;
			String leMessage;
			leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"),
					(Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.creerPartie();
		} catch (JAXBException | IOException | JMSException | XMLStreamException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
