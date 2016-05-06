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
import model.CreerCompte;

public class CallCreerCompte implements Callable<Boolean> {
	private Receiver r = new Receiver();
	private Decodeur d = new Decodeur();
	private Sender s = new Sender();
	private Encodeur e = new Encodeur();
	private String login;
	private Context ctx;
	private String mdp;

	public CallCreerCompte(String login, String mdp, Context ctx) {
		super();
		this.login = login;
		this.ctx = ctx;
		this.mdp = mdp;
	}
	/*
	public boolean demandeCreerCompte(String login, String mdp, Context ctx) {
		try {
			CreerCompte newAcc = new CreerCompte();
			newAcc.setLogin(login);
			newAcc.setPass(mdp);
			Command c = newAcc;
			String leMessage;
			leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.creerCompte();
		} catch (JAXBException | IOException | JMSException | XMLStreamException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	 */
	@Override
	public Boolean call() throws Exception {
		try {
			// TODO Auto-generated method stub
			CreerCompte newAcc = new CreerCompte();
			newAcc.setLogin(login);
			newAcc.setPass(mdp);
			Command c = newAcc;
			String leMessage;
			leMessage = e.marshal(c);
			s.sendMessage(leMessage, ctx, (Destination) ctx.lookup("sender"), (Destination) ctx.lookup("receiver"));
			String mess = this.r.receive();
			Command command = this.d.unmarshal(mess);
			return command.creerCompte();
		} catch (JAXBException | IOException | JMSException | XMLStreamException |

				NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
