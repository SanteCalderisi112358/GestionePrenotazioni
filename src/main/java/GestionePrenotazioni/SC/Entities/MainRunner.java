package GestionePrenotazioni.SC.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import GestionePrenotazioni.SC.CustomException.UserNotFoundException;
import GestionePrenotazioni.SC.Service.EdificioService;
import GestionePrenotazioni.SC.Service.PostazioneService;
import GestionePrenotazioni.SC.Service.PrenotazioneService;
import GestionePrenotazioni.SC.Service.UtenteService;

@Component
public class MainRunner implements CommandLineRunner {
	@Autowired
	UtenteService utenteSrv;
	@Autowired
	EdificioService edificioSrv;
	@Autowired
	PostazioneService postazioneSrv;
	@Autowired
	PrenotazioneService prenotazioneSrv;
	@Override
	public void run(String... args) throws Exception {
		
		
		Faker faker = new Faker(Locale.ITALIAN);
		/* CREO 30 UTENTI E LI SALVO NEL DB */
		
//		for (int i = 0; i < 10; i++) {
//			Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(),
//					faker.lordOfTheRings().character(), faker.internet().emailAddress());
//			utenteSrv.save(utente);
//		}

		/* CREO 10 EDIFICI E LI SALVO NEL DB */
//		for (int i = 0; i < 5; i++) {
//			Edificio edificio = new Edificio(faker.backToTheFuture().character(), faker.address().streetAddress(),
//					faker.address().city());
//			edificioSrv.save(edificio);
//		}

		/* CREO 20 POSTAZIONI LIBERE (libera=true) E LE SALVO */

		List<Edificio> listaEdifici = new ArrayList<Edificio>();
		listaEdifici = edificioSrv.findAll();
		// System.err.println("Lista edifici prese dal DB");
		// listaEdifici.forEach(e -> System.err.println(e));
//		TipoPostazione tipo = TipoPostazione.values()[0];
//		System.err.println(tipo);
//		for (int i = 0; i < 20; i++) {
//			Postazione postazione = new Postazione("Bello, Bellissimo, pulito",
//					TipoPostazione.values()[faker.number().numberBetween(0, 2)], faker.number().numberBetween(20, 40),
//					true, listaEdifici.get(faker.number().numberBetween(0, listaEdifici.size() - 1)));
//			postazioneSrv.save(postazione);
//		}
		/* CREO 20 POSTAZIONI OCCUPATE (libera=false) E LE SALVO */


//		for (int i = 0; i < 20; i++) {
//			Postazione postazione = new Postazione("Bello, Bellissimo, pulito",
//					TipoPostazione.values()[faker.number().numberBetween(0, 2)], faker.number().numberBetween(20, 40),
//					false, listaEdifici.get(faker.number().numberBetween(0, listaEdifici.size() - 1)));
//			postazioneSrv.save(postazione);
//		}

		List<Postazione> listaPostazioni = new ArrayList<Postazione>();
		listaPostazioni = postazioneSrv.findAll();
		// System.err.println("Lista postazioni prese dal DB");
		// listaPostazioni.forEach(p -> System.err.println(p));

		List<Utente> listaUtenti = utenteSrv.findAll();
		// System.err.println("Lista utenti prese dal DB");
		// listaUtenti.forEach(ut -> System.err.println(ut));


	/*
	 * PROVE SALVATAGGIO DI UNA PRENOTAZIONE EFFETTUATA OGGI DA UN UTENTE PER LA
	 * PRIMA VOLTA VERIFICA CHE LA POSTAZIONE SIA LIBERA
	 */

//	Prenotazione prenotazione01 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione01);
//	Prenotazione prenotazione02 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione02);
//	Prenotazione prenotazione03 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione03);
//	Prenotazione prenotazione04 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione04);
//	Prenotazione prenotazione05 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione05);
//	Prenotazione prenotazione06 = new Prenotazione(LocalDate.now(),
//			listaUtenti.get(faker.number().numberBetween(0, listaUtenti.size() - 1)),
//			listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));
//	prenotazioneSrv.checkAndSave(prenotazione06);
		

	/* NUOVA PRENOTAZIONE E CONTROLLI */
	try {
		
		/*1. PRENDO UN UTENTE DAL DB*/
		Utente utente = utenteSrv.findByid(55);
		/*2. ISTANZIO UNA PRENOTAZIONE RANDOM*/
		Prenotazione prenotazione07 = new Prenotazione(LocalDate.of(2023, 10, 6), utente,
				listaPostazioni.get(faker.number().numberBetween(0, listaPostazioni.size() - 1)));

		prenotazioneSrv.checkAndSave(prenotazione07);
	} catch (UserNotFoundException ex) {
		System.err.println(ex.getMessage());
	}
	// System.err.println(utenteSrv.checkUtentePrenotazioneGiorno(58,
	// LocalDate.of(2023, 07, 30)));


}
}
