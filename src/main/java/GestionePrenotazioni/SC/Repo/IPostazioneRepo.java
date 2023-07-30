package GestionePrenotazioni.SC.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import GestionePrenotazioni.SC.Entities.Postazione;
import GestionePrenotazioni.SC.Entities.TipoPostazione;

@Repository
public interface IPostazioneRepo extends JpaRepository<Postazione, Integer> {
	@Query("SELECT p FROM Postazione p JOIN p.edificio WHERE p.tipoPostazione = :tipoPostazione AND UPPER (p.edificio.citta) LIKE UPPER(concat('%', :citta, '%'))")
	public List<Postazione> ricercaCittaETipoPostazione(TipoPostazione tipoPostazione, String citta);
}
