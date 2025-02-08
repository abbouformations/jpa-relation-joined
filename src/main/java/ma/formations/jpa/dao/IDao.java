package ma.formations.jpa.dao;

import ma.formations.jpa.service.model.Personne;

import java.util.List;

public interface IDao {
    void save(Personne p);

    void remove(String nom, String prenom);

    List<Personne> getAll();

    Personne getById(Long id);

    List<Personne> getByName(String name);

}
