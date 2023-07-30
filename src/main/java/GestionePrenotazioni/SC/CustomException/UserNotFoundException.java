package GestionePrenotazioni.SC.CustomException;

import GestionePrenotazioni.SC.Entities.Utente;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(Utente utente) {
		super("Utente con id: " + utente.getId() + " non trovato");
	}
}
