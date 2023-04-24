package fr.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import fr.formation.model.Salon;
import fr.formation.repo.ISalonRepository;

public class SalonRepositoryJpa extends AbstractRepositoryJpa implements ISalonRepository {

	@Override
	public List<Salon> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Salon> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Salon save(Salon entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}
    
}
