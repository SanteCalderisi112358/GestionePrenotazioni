package GestionePrenotazioni.SC.Repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Utente;

@Repository
public interface IUtenteRepo extends JpaRepository<Utente, Integer> {
	
	
	@Query("SELECT COUNT(*) FROM Prenotazione p JOIN p.utente u WHERE u.id = :idUtente AND p.dataInizioPrenotazione = :dataInizioPrenotazione")
	public int checkPrenotazioneNvoltePerUtente(int idUtente, LocalDate dataInizioPrenotazione);

}
