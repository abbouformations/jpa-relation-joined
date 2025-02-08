package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.service.model.Etudiant;
import ma.formations.jpa.service.model.Personne;
import ma.formations.jpa.service.model.Professeur;

import java.util.Date;

/**
 * Créer des personnes, des étudiants et des professeurs
 */
public class Test1 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        dao.save(new Personne("nom_personne_1", "prenom_personne_1"));
        dao.save(new Personne("nom_personne_2", "prenom_personne_2"));

        dao.save(new Professeur("nom_professeur_1", "prenom_professeur_1", "Docteur"));
        dao.save(new Professeur("nom_professeur_2", "prenom_professeur_2", "INGENIEUR D'ETAT"));

        dao.save(new Etudiant("nom_etudiant_1", "prenom_etudiant_1", new Date()));
        dao.save(new Etudiant("nom_etudiant_2", "prenom_etudiant_2", new Date()));
        dao.save(new Etudiant("nom_etudiant_3", "prenom_etudiant_3", new Date()));
    }

}
