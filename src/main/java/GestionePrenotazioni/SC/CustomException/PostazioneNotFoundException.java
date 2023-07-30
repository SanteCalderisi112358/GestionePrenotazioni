package GestionePrenotazioni.SC.CustomException;

import GestionePrenotazioni.SC.Entities.Postazione;

public class PostazioneNotFoundException extends Exception {

	public PostazioneNotFoundException(Postazione postazione) {
		super("Postazione con id: " + postazione.getId() + " non trovato");
	}
}
