package GestionePrenotazioni.SC.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Edificio {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String indirizzo;
	private String città;

	public Edificio(String nome, String indirizzo, String città) {

		this.nome = nome;
		this.indirizzo = indirizzo;
		this.città = città;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", Nome=" + nome + ", Indirizzo=" + indirizzo + ", Città=" + città + "]";
	}

}
