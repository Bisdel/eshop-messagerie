package fr.formation;

import java.util.Optional;

import fr.formation.factory.RepositoryFactory;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

public class Identification {
    
    public static Optional<Utilisateur> checkUsername (Utilisateur user) {
        IUtilisateurRepository repoUtilisateur = RepositoryFactory.createUtilisateurRepository();

        System.out.println("Veuillez entrer votre nom d'utilisateur :");        
        user.setUsername(ApplicationUtilisateur.sc.nextLine());

        for (Utilisateur u : repoUtilisateur.findAll()){
            if (user.getUsername() == u.getUsername()){
                System.out.println("Utilisateur trouvé !");
                return Optional.of(user);
            }
        }
        System.out.println("Utilisateur non trouvé. Veuillez réessayer.");
        return Optional.empty();
    }

    public static Optional<Utilisateur> checkPassword(Utilisateur user) {
        return null;
    }
}
