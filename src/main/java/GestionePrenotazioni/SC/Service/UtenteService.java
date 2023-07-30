package GestionePrenotazioni.SC.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionePrenotazioni.SC.CustomException.UserNotFoundException;
import GestionePrenotazioni.SC.Entities.Utente;
import GestionePrenotazioni.SC.Repo.IUtenteRepo;

@Service
public class UtenteService {
	@Autowired
	IUtenteRepo utenteRepo;

	public void save(Utente utente) {
		utenteRepo.save(utente);
		System.err
				.println("L'utente " + utente.getNome() + " " + utente.getCognome() + " è stato salvato correttamente");
	}

	public List<Utente> findAll() {
		List<Utente> listaUtenti = utenteRepo.findAll();
		if (listaUtenti.isEmpty()) {
			System.err.println("Non ci sono utenti nel database");
			return new ArrayList<>();
		} else {
			return listaUtenti;
		}

	}

	public Utente findByid(int idUtente) throws UserNotFoundException {
		return utenteRepo.findById(idUtente).orElseThrow(() -> new UserNotFoundException(idUtente));

	}

	public int checkUtentePrenotazioneGiorno(int idUtente, LocalDate data) {
		return utenteRepo.checkPrenotazioneNvoltePerUtente(idUtente, data);
	}
}
