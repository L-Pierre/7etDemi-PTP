package Schema;

import java.util.ArrayList;

import model.Partie;
import model.ResponseAuthentifier;
import model.ResponseCreerCompte;
import model.ResponseCreerPartie;
import model.ResponseListePartie;

public abstract class Command {
	
	public boolean creerCompte() {
		if (this.getClass().getName().equals("model.ResponseCreerCompte")) {
			ResponseCreerCompte repCompte = (ResponseCreerCompte) this;
			return repCompte.isOk();
		}
		return false;
	}

	public int authentification() {
		if (this.getClass().getName().equals("model.ResponseAuthentifier")) {
			ResponseAuthentifier repAuth = (ResponseAuthentifier) this;
			return repAuth.getIdUser();
		}
		return -1;
	}

	public Partie creerPartie() {
		if (this.getClass().getName().equals("model.ResponseCreerPartie")) {
			ResponseCreerPartie repCP = (ResponseCreerPartie) this;
			return repCP.getPartie();
		}
		return null;
	}
	
	public ArrayList<Partie> listePartie(){
		if (this.getClass().getName().equals("model.ResponseListePartie")) {
			ResponseListePartie rcp = (ResponseListePartie) this ;
			return (ArrayList<Partie>) rcp.getListePartie();
		}
		return null;
	}
}
