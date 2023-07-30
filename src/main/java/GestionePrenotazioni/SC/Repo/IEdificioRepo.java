package GestionePrenotazioni.SC.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Edificio;

@Repository
public interface IEdificioRepo extends JpaRepository<Edificio, Integer> {

}
