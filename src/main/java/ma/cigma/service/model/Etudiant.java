package ma.cigma.service.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Etudiant extends Personne {
	private Date dateInscription;

	public Etudiant(String nom, String prenom, Date dateInscription) {
		super(nom, prenom);
		this.dateInscription = dateInscription;
	}
}
