package fr.formation.factory;

import fr.formation.repo.IMessageRepository;
import fr.formation.repo.ISalonRepository;
import fr.formation.repo.IUtilisateurRepository;
import fr.formation.repo.jpa.MessageRepositoryJpa;
import fr.formation.repo.jpa.SalonRepositoryJpa;
import fr.formation.repo.jpa.UtilisateurRepositoryJpa;

public class RepositoryFactory {
    
    public static IMessageRepository createMessageRepository() {
        return new MessageRepositoryJpa();
    }

    public static ISalonRepository createSalonRepository(){
        return new SalonRepositoryJpa();
    }

    public static IUtilisateurRepository createUtilisateurRepository(){
        return new UtilisateurRepositoryJpa();
    }
}
