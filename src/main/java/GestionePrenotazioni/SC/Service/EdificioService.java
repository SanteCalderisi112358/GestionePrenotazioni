package GestionePrenotazioni.SC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionePrenotazioni.SC.Entities.Edificio;
import GestionePrenotazioni.SC.Repo.IEdificioRepo;

@Service
public class EdificioService {
	@Autowired
	IEdificioRepo edificioRepo;

public void save(Edificio edificio) {
	edificioRepo.save(edificio);
	System.err.println(edificio.toString() + " salvato corretamente");
}

public List<Edificio> findAll() {
	List<Edificio> listaEdifici = edificioRepo.findAll();
	if (listaEdifici.isEmpty()) {
		System.err.println("Non ci sono postazioni nel database");
		return new ArrayList<>();
	} else {
		return listaEdifici;
	}

}
}
