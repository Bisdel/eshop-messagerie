package fr.formation;

import java.util.Scanner;

import fr.formation.model.Utilisateur;

public class Application {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Bienvenue sur EMessagerie, le service de messagerie de votre EShop préféré !");
        Utilisateur utilisateur = new Utilisateur();

        if(Identification.checkUsername(utilisateur).isPresent()){
            if (Identification.checkPassword(utilisateur).isPresent()){
                System.out.println("Bienvenue "+utilisateur.getUsername()+" !");
                ApplicationUtilisateur.main(utilisateur);
            }
        }
        else {
            Inscription.sInscrire();
        }

    }
}
