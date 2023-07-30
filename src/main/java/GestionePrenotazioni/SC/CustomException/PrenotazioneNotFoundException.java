package GestionePrenotazioni.SC.CustomException;

import GestionePrenotazioni.SC.Entities.Prenotazione;

public class PrenotazioneNotFoundException extends Exception {
	public PrenotazioneNotFoundException(Prenotazione prenotazione) {
		super("Prenotazione con id: " + prenotazione.getId() + " non trovata");
	}
}
