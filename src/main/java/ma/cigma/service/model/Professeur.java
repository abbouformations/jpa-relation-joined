package ma.cigma.service.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Professeur extends Personne {
	private String diplome;

	public Professeur(String nom, String prenom, String diplome) {
		super(nom, prenom);
		this.diplome = diplome;
	}
}
