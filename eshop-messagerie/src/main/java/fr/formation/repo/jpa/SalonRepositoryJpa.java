package fr.formation.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import fr.formation.model.Salon;
import fr.formation.repo.ISalonRepository;
import jakarta.persistence.EntityManager;

public class SalonRepositoryJpa extends AbstractRepositoryJpa implements ISalonRepository {

	@Override
	public List<Salon> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em.createQuery("select s from Salon s ", Salon.class).getResultList();
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Salon> findById(int id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Salon.class, id));
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}

	}

	@Override
	public Salon save(Salon entity) {
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
		try (EntityManager em = emf.createEntityManager()) {
			em.getTransaction().begin();

			try {
				em.remove(em.find(Salon.class, id));
				em.getTransaction().commit();
			}

			catch (Exception ex) {
				em.getTransaction().rollback();
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
