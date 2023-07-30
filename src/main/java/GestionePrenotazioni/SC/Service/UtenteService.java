package GestionePrenotazioni.SC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GestionePrenotazioni.SC.Repo.IUtenteRepo;

@Service
public class UtenteService {
	@Autowired
	IUtenteRepo utenteRepo;
}
