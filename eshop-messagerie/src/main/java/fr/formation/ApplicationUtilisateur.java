package fr.formation;

import java.util.Scanner;

import fr.formation.factory.RepositoryFactory;
import fr.formation.model.Message;
import fr.formation.model.Salon;
import fr.formation.model.Utilisateur;
import fr.formation.repo.IMessageRepository;
import fr.formation.repo.ISalonRepository;



public class ApplicationUtilisateur {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.println("Bienvenue sur EMessagerie, le service de messagerie de votre EShop préféré !");
        Utilisateur utilisateur = new Utilisateur();

		if(Identification.checkUsername(utilisateur).isPresent()){
            if (Identification.checkPassword(utilisateur).isPresent()){
                System.out.println("Bienvenue "+utilisateur.getUsername()+" !");
            }
        }
        else {
            Inscription.sInscrire(utilisateur);
        }

		int choixMenu = 0;

		do {
			choixMenu = Menu.print();
			switch (choixMenu) {
			case 01:crerSalon();break;
			case 02:listerSalon();break;
			case 03:listerMsgSalon();break;
			case 04:envoyerMsgSalon();break;
			}
		} while (choixMenu != 0);
		Saisie.sc.close();
	}

	private static void crerSalon() {
		Salon salon = new Salon();
		ISalonRepository repoSalon = RepositoryFactory.createSalonRepository();
		String nom =Saisie.next("Son nom est : ");
		salon.setNom(nom);
		repoSalon.save(salon);
		System.out.println("Salon #" + salon.getId() + " ajouté !");
	      		
	}
	
	

	private static void listerSalon() {
	ISalonRepository repoSalon =RepositoryFactory.createSalonRepository();
	 for(Salon s : repoSalon.findAll()) {
		 System.out.println(s.getId() + "- " + s.getNom() + " " );
	 }
		
	}

	private static void listerMsgSalon() {
		IMessageRepository repoMessage =RepositoryFactory.createMessageRepository();
		 for(Message m : repoMessage.findAll()) {
			 System.out.println(m.getId() + "- " + m.getDate() + " " + " " + m.getContenu() );
		 }
	}

	private static void envoyerMsgSalon() {
		IMessageRepository repoMessage =RepositoryFactory.createMessageRepository();
		Message message = new Message();
		message.setContenu(Saisie.next(" le contenu de votre message : "));
		
		
		
	}

}
