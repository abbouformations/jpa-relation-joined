package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;
import ma.formations.jpa.service.model.Professeur;

/**
 * Récupérer la liste des professeurs
 */
public class Test3 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {

        dao.getAll().stream().
                filter(p -> p instanceof Professeur).
                map(p -> (Professeur) p).
                forEach(System.out::println);
    }

}

