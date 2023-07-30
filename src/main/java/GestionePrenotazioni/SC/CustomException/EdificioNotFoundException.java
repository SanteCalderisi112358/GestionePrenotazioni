package GestionePrenotazioni.SC.CustomException;

import GestionePrenotazioni.SC.Entities.Edificio;

public class EdificioNotFoundException extends Exception {
	public EdificioNotFoundException(Edificio edificio) {
		super("Edificio con id: " + edificio.getId() + " non trovato");
	}
}

