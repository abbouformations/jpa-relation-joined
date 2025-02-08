package ma.formations.jpa.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

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
