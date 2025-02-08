package ma.formations.jpa;

import ma.formations.jpa.dao.DaoImpl;
import ma.formations.jpa.dao.IDao;

/**
 * Récupérer la liste des personnes
 */
public class Test2 {
    static IDao dao = new DaoImpl();

    public static void main(String[] args) {
        dao.getAll().forEach(System.out::println);
    }

}

