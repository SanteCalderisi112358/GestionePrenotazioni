package GestionePrenotazioni.SC.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

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
		/* 1. CREO 10 UTENTI E LI SALVO NEL DB */
		
//		for (int i = 0; i < 10; i++) {
//			Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(),
//					faker.lordOfTheRings().character(), faker.internet().emailAddress());
//			utenteSrv.save(utente);
//		}

		/* 2. CREO 10 EDIFICI E LI SALVO NEL DB */
//		for (int i = 0; i < 5; i++) {
//			Edificio edificio = new Edificio(faker.backToTheFuture().character(), faker.address().streetAddress(),
//					faker.address().city());
//			edificioSrv.save(edificio);
//		}

		/* 3. CREO 20 POSTAZIONI LIBERE (libera=true) E LE SALVO */

		// List<Edificio> listaEdifici = new ArrayList<Edificio>();
		// listaEdifici = edificioSrv.findAll();
		// System.err.println("Lista edifici prese dal DB");
		// listaEdifici.forEach(e -> System.err.println(e));

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




		

	/* NUOVA PRENOTAZIONE E CONTROLLI */
//	try {
//
//		/* 1. PRENDO UN UTENTE DAL DB */
//		Utente utente = utenteSrv.findByid(108);
//		/* 2. PRENDO UNA POSTAZIONE DAL DB */
//		Postazione postazione = postazioneSrv.findByid(207);
//		/* 3. ISTANZIO UNA NUOVA PRENOTAZIONE */
//		Prenotazione prenotazione07 = new Prenotazione(LocalDate.now(), utente, postazione);
//		/* CONTROLLO LA PRENOTAZIONE PRIMA DI SALVARLA CORRETTAMENTE */
//		prenotazioneSrv.checkAndSave(prenotazione07);
//	} catch (UserNotFoundException ex) {
//		System.err.println(ex.getMessage());
//	} catch (PostazioneNotFoundException ex) {
//		System.err.println(ex.getMessage());
//	}


	/* RICERCA PER CITTA' E TIPO POSTAZIONE */

	TipoPostazione tipoPostazione = TipoPostazione.SALA_RIUNIONI;
	String citta = "San";
	List<Postazione> listaPostazioniCittaTipo = postazioneSrv.ricercaCittaTipo(tipoPostazione, citta);
	if (listaPostazioniCittaTipo == null) {
		System.err.println("Non esistono postazioni per la tua ricerca");
	} else {
		System.err.println("Lista Postazioni " + tipoPostazione + " a " + citta);
		listaPostazioniCittaTipo.forEach(postazione -> System.err.println(postazione));
	}
	

}
}
