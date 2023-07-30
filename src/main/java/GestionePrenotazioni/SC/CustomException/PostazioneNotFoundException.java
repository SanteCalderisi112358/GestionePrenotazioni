package GestionePrenotazioni.SC.CustomException;

public class PostazioneNotFoundException extends Exception {

	public PostazioneNotFoundException(int idPostazione) {
		super("Postazione con id: " + idPostazione + " non trovato");
	}
}
