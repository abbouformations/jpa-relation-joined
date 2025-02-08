package ma.formations.jpa.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

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
