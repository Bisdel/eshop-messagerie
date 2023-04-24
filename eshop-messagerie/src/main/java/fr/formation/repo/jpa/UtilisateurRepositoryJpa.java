package fr.formation.repo.jpa;

import java.util.List;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;
import jakarta.persistence.EntityManager;

public class UtilisateurRepositoryJpa extends AbstractRepositoryJpa implements IUtilisateurRepository {
    
    public List<Utilisateur> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
            return em
            .createQuery("select u from Utilisateur u", Utilisateur.class)
            .getResultList();
        }
    }
}
