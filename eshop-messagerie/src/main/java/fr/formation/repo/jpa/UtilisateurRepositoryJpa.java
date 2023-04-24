package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Optional<Utilisateur> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
	
		try (EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();

			try {
				if (entity.getId() == 0) {
					em.persist(entity);
				}

				else {
					entity = em.merge(entity);
				}

				em.getTransaction().commit();
			}

			catch (Exception ex) {
				ex.printStackTrace();
				em.getTransaction().rollback();
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		return entity;
		
	
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
}
