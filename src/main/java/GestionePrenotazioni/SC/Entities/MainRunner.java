package GestionePrenotazioni.SC.Entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import GestionePrenotazioni.SC.CustomException.PostazioneNotFoundException;
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
		List<Edificio> listaEdifici = edificioSrv.findAll();
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

		List<Utente> listaUtenti = utenteSrv.findAll();





		Scanner scanner = new Scanner(System.in);
		try {
			int sceltaIniziale;

			do {
				System.out.println("**********");
				System.out.print("Scegli un'opzione: \n");
				System.out.println("1. Iscriviti");
				System.out.println("2. Accedi");
				System.out.println("0. Esci");

				sceltaIniziale = Integer.parseInt(scanner.nextLine());

				switch (sceltaIniziale) {
				case 1:
					System.out.println("Inserisci il tuo NOME (0 per tornare indietro)");
					String nome = getInput(scanner);
					if (nome.equals("0")) {
						break;
					}

					System.out.println("Inserisci il tuo COGNOME (0 per tornare indietro)");
					String cognome = getInput(scanner);
					if (cognome.equals("0")) {
						break;
					}

					System.out.println("Inserisci il tuo USERNAME (0 per tornare indietro)");
					String username = getInput(scanner);
					if (username.equals("0")) {
						break;
					}

					System.out.println("Inserisci il tuo INDIRIZZO EMAIL (0 per tornare indietro)");
					String email = getInput(scanner);
					if (email.equals("0")) {
						break;
					} else {
						Utente nuovoUtente = new Utente(nome, cognome, username, email);
						utenteSrv.save(nuovoUtente);
					}

					System.out.println("Hai completato l'iscrizione!");
					break;

				case 2:
					try {
						System.out.println("**********");
						System.out.print("Inserisci il tuo id: ");
						int idUtenteAccesso = Integer.parseInt(scanner.nextLine());
						Utente utente = utenteSrv.findByid(idUtenteAccesso);
						int scelta;
						do {
							System.out.println("Benvenuto " + utente.getNome());
							System.out.println("1. Visualizza e prenota una delle nostre postazioni");
							System.out.println("2. Fai una ricerca");
							System.out.println("0. Torna indietro");

							System.out.print("Scegli un'opzione: ");
							scelta = Integer.parseInt(scanner.nextLine());
							switch (scelta) {
							case 1:
								int sceltaPostazioneID;
								List<Postazione> postazioni = postazioneSrv.findAll();
								System.out.println("**********");
								System.out.println("Le nostre postazioni:");
								for (int i = 0; i < postazioni.size(); i++) {
									System.out.println((i + 1) + " - " + postazioni.get(i).toString());
								}
								System.out.println("Inserisci id:");
								sceltaPostazioneID = Integer.parseInt(scanner.nextLine());

								try {
									Postazione postazioneScelta = postazioneSrv.findByid(sceltaPostazioneID);
									System.out.println("Hai scelto:");
									System.out.println(postazioneScelta.toString());
									System.out.println("**********");
									System.out.println("Inserisci ANNO (YYYY)");

									/* NUOVA PRENOTAZIONE E CONTROLLI */
									try {
										int anno = Integer.parseInt(scanner.nextLine());
										System.out.println("Inserisci MESE(MM)");
										int mese = Integer.parseInt(scanner.nextLine());
										if (mese < 1 && mese > 12) {
											System.err.println("Mese non valido!");
											return;
										}
										System.out.println("Inserisci GIORNO(DD)");
										int giorno = Integer.parseInt(scanner.nextLine());
										if (giorno < 1 && giorno > 31) {
											System.err.println("Giorno non valido!");
											return;
										}
										Prenotazione nuovaPrenotazione = new Prenotazione(
												LocalDate.of(anno, mese, giorno), utente, postazioneScelta);
										prenotazioneSrv.checkAndSave(nuovaPrenotazione);
									} catch (UserNotFoundException ex) {
										System.err.println(ex.getMessage());
									}
								} catch (PostazioneNotFoundException ex) {
									System.err.println(ex.getMessage());
								} catch (NumberFormatException ex) {
									System.err.println("Formato non valido");
								}

								System.out.println("**********");
								break;
							case 2:
								System.out.println("**********");
								System.out.println("Scegli il tipo di postazione:");
								System.out.println("1. Open Space");
								System.out.println("2. Privato");
								System.out.println("3. Sala Riunione");
								int sceltaTipoPostazione = Integer.parseInt(scanner.nextLine());
								TipoPostazione tipoPostazione = null;

								switch (sceltaTipoPostazione) {
								case 1:
									tipoPostazione = TipoPostazione.OPEN_SPACE;
									break;
								case 2:
									tipoPostazione = TipoPostazione.PRIVATO;
									break;
								case 3:
									tipoPostazione = TipoPostazione.SALA_RIUNIONI;
									break;
								default:
									System.err.println("Scelta non valida! Riprova");
									return;
								}

								System.out.println("Inserisci il nome della città (0 per tornare indietro)");
								String citta = getInput(scanner);
								if (citta.equals("0")) {
									break;
								}

								List<Postazione> listaPostazioniCittaTipo = postazioneSrv
										.ricercaCittaTipo(tipoPostazione, citta);
								if (listaPostazioniCittaTipo == null) {
									System.err.println("Non esistono postazioni per la tua ricerca");
								} else {
									System.err.println("Lista Postazioni " + tipoPostazione + " a " + citta);
									listaPostazioniCittaTipo.forEach(postazione -> System.err.println(postazione));
								}
								break;
							
							case 0:
								System.out.println("**********");

								break;
							default:
								System.err.println("Scelta non valida! Riprova");
								System.out.println("**********");
							}
						} while (scelta != 0);
					} catch (UserNotFoundException ex) {
						System.err.println(ex.getMessage());
					}
					break;

				default:
					System.out.println("Scelta non valida! Riprova");
				}
			} while (sceltaIniziale != 0);

			scanner.close();
		} catch (Exception ex) {
			System.err.println("Formato non valido");
		}

	}

	private static String getInput(Scanner scanner) {
		String input;
		do {
			input = scanner.nextLine();
			if (input.equals("0")) {
				return "0";
			}
		} while (input.trim().isEmpty());
		return input;
	}
}
