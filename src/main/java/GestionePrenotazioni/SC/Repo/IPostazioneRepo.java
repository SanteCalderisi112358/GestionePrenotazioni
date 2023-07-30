package GestionePrenotazioni.SC.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Postazione;

@Repository
public interface IPostazioneRepo extends JpaRepository<Postazione, Integer> {


}
