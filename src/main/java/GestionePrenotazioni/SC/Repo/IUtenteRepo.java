package GestionePrenotazioni.SC.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Utente;

@Repository
public interface IUtenteRepo extends JpaRepository<Utente, Integer> {

}
