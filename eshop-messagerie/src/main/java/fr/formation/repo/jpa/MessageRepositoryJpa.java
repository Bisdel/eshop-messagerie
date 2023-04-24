package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Message;
import fr.formation.repo.IMessageRepository;

public class MessageRepositoryJpa extends AbstractRepositoryJpa implements IMessageRepository {

	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Message> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Message save(Message entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
    
}
