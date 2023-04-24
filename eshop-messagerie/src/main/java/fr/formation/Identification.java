package fr.formation;

import fr.formation.factory.RepositoryFactory;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IUtilisateurRepository;

public class Identification {
    
    public static Utilisateur sIdentifier () {
        IUtilisateurRepository repoUtilisateur = RepositoryFactory.createUtilisateurRepository();
        Utilisateur user = new Utilisateur();
        
        System.out.println("Veuillez entrer votre nom d'utilisateur :");        
        user.setUsername(Application.sc.nextLine());

        for (Utilisateur util : repoUtilisateur.findAll()){
            if 
        }
    }

}
