package ma.formations.jpa.dao;

import ma.formations.jpa.service.model.Personne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class DaoImpl implements IDao {
    private static final Logger log = LogManager.getLogger(DaoImpl.class);
    private EntityManager session;
    private EntityTransaction tx;

    @Override
    public void save(Personne p) {
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            session.merge(p);
            tx.commit();
            log.info("{} ajouté avec succés", p);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("erreur dans save() : {}", e);
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void remove(String nom, String prenom) {
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            tx = session.getTransaction();
            tx.begin();
            Query requete = session.createQuery("select p from Personne p where p.nom=:nom and p.prenom=:prenom");
            requete.setParameter("nom", nom);
            requete.setParameter("prenom", prenom);
            List personsFound = requete.getResultList();
            if (personsFound == null || personsFound.isEmpty())
                return;
            personsFound.forEach(bo -> session.remove(bo));
            tx.commit();
            log.info("les personnes [{},{}] ont été supprimées avec succés", nom, prenom);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("erreur dans remove() : {}", e);
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }

    }

    @Override
    public List<Personne> getAll() {
        List<Personne> result = null;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            result = session.createQuery("FROM Personne").getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("erreur dans getAll() : {}", e);
            return null;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Personne getById(Long id) {
        Personne result = null;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            result = session.find(Personne.class, id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("erreur dans getById(): {}", e);
            return null;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Personne> getByName(String name) {
        List<Personne> result = null;
        try {
            session = SessionBuilder.getSessionfactory().createEntityManager();
            Query requete = session.createQuery("select p from Personne p where p.nom like :name");
            requete.setParameter("name", name);
            result = requete.getResultList();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("erreur dans getByName() : {}", e);
            return null;
        } finally {
            if (session != null)
                session.close();
        }
    }

}
