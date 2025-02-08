package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

/**
 * Supprimer une personne donnée
 */
public class Test4 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        final String nom = "nom_professeur_1";
        final String prenom = "prenom_professeur_1";

        dao.remove(nom, prenom);

        System.out.printf("Professeur [%s,%s] supprimée avec succés", nom, prenom);
    }

}

