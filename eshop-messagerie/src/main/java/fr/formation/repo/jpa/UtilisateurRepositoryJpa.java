package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;
import jakarta.persistence.EntityManager;

public class UtilisateurRepositoryJpa extends AbstractRepositoryJpa implements IUtilisateurRepository {

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Utilisateur> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
    
    public List<Utilisateur> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
            return em
            .createQuery("select u from Utilisateur u", Utilisateur.class)
            .getResultList();
        }
    }
}
