package GestionePrenotazioni.SC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionePrenotazioni.SC.CustomException.PostazioneNotFoundException;
import GestionePrenotazioni.SC.CustomException.UserNotFoundException;
import GestionePrenotazioni.SC.Entities.Postazione;
import GestionePrenotazioni.SC.Entities.Prenotazione;
import GestionePrenotazioni.SC.Entities.Utente;
import GestionePrenotazioni.SC.Repo.IPrenotazioneRepo;

@Service
public class PrenotazioneService {
	@Autowired
	IPrenotazioneRepo prenotazioneRepo;
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	PostazioneService postazioneSrv;

	public void checkAndSave(Prenotazione prenotazione) throws UserNotFoundException, PostazioneNotFoundException {
		int idUtente = prenotazione.getUtente().getId();
		int idPostazione = prenotazione.getPostazione().getId();
		System.err.println("Utente id: " + idUtente);
		System.err.println("Postazione id: " + idPostazione);
		Utente utente = utenteSrv.findByid(idUtente);
		Postazione postazione = postazioneSrv.findByid(idPostazione);
		System.err.println(utente);
		System.err.println(postazione);
		if(!postazione.isLibera()) {
			System.err.println("La postazione scelta è OCCUPATA");
			return;
		} else if (utenteSrv.checkUtentePrenotazioneGiorno(idUtente, prenotazione.getDataInizioPrenotazione()) > 0) {
			System.err.println(utente.toString() + " ha già effettuato una prenotazione per il giorno "
					+ prenotazione.getDataInizioPrenotazione());
			return;
		}else if(postazione.isLibera()&&utenteSrv.checkUtentePrenotazioneGiorno(idUtente, prenotazione.getDataInizioPrenotazione()) == 0) {
			postazione.setLibera(false);
			postazioneSrv.save(postazione);
			prenotazioneRepo.save(prenotazione);
			System.err.println(prenotazione.toString() + " salvata correttamente");
			return;
		}

	}
}

