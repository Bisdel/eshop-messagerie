package fr.formation.repo;

import java.util.List;

public interface IRepository<T> {
    
    public List<T> findAll();
}
