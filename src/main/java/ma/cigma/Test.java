package ma.cigma;

import java.util.Date;

import ma.cigma.dao.DaoImpl;
import ma.cigma.dao.IDao;
import ma.cigma.service.model.Etudiant;
import ma.cigma.service.model.Personne;
import ma.cigma.service.model.Professeur;

public class Test {
	static IDao dao = new DaoImpl();

	static void saveProfesseur(String nom, String prenom, String diplome) {
		dao.save(new Professeur(nom, prenom, diplome));
	}

	static void saveEtudiant(String nom, String prenom, Date dateInscription) {
		dao.save(new Etudiant(nom, prenom, dateInscription));
	}

	static void savePersonne(String nom, String prenom) {
		dao.save(new Personne(nom, prenom));
	}

	public static void main(String[] args) {
		savePersonne("nom_petrsonne_1", "prenom_personne_1");
		savePersonne("nom_petrsonne_2", "prenom_personne_2");
		
		saveProfesseur("nom_professeur_1", "prenom_professeur_1", "DICTEUR D'ETAT");
		saveProfesseur("nom_professeur_2", "prenom_professeur_2", "INGENIEUR D'ETAT");
		
		saveEtudiant("nom_etudiant_1", "prenom_etudiant_1", new Date());
		saveEtudiant("nom_etudiant_2", "prenom_etudiant_2", new Date());
		saveEtudiant("nom_etudiant_3", "prenom_etudiant_3", new Date());
	}

}
