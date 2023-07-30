package GestionePrenotazioni.SC.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Prenotazione;

@Repository
public interface IPrenotazioneRepo extends JpaRepository<Prenotazione, Integer> {

}
