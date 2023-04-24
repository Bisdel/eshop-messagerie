package fr.formation.repo.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.formation.model.Message;
import fr.formation.repo.IMessageRepository;
import jakarta.persistence.EntityManager;

public class MessageRepositoryJpa extends AbstractRepositoryJpa implements IMessageRepository {

	@Override
	public List<Message> findAll() {
		try (EntityManager em = emf.createEntityManager()) {
			return em.createQuery("select m from Message m ", Message.class).getResultList();
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Message> findById(int id) {
		try (EntityManager em = emf.createEntityManager()) {
			return Optional.ofNullable(em.find(Message.class, id));
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public Message save(Message entity) {
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
				em.remove(em.find(Message.class, id));
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
