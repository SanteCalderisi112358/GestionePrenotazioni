package GestionePrenotazioni.SC.CustomException;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(int idUtente) {
		super("Utente con id: " + idUtente + " non trovato");
	}
}
