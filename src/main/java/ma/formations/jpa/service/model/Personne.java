package ma.formations.jpa.service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }
}
