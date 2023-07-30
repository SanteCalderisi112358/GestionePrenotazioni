package GestionePrenotazioni.SC.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionePrenotazioni.SC.CustomException.PostazioneNotFoundException;
import GestionePrenotazioni.SC.Entities.Postazione;
import GestionePrenotazioni.SC.Repo.IPostazioneRepo;

@Service
public class PostazioneService {
	@Autowired
	IPostazioneRepo postazioneRepo;

	public void save(Postazione postazione) {
		postazioneRepo.save(postazione);
		System.err.println(postazione.toString() + " salvata correttamente");
	}

	public List<Postazione> findAll() {
		List<Postazione> listaPostazioni = postazioneRepo.findAll();
		if (listaPostazioni.isEmpty()) {
			System.err.println("Non ci sono postazioni nel database");
			return new ArrayList<>();
		} else {
			return listaPostazioni;
		}

	}

	public Postazione findByid(int idPostazione) throws PostazioneNotFoundException {
		return postazioneRepo.findById(idPostazione).orElseThrow(() -> new PostazioneNotFoundException(idPostazione));

	}

}
