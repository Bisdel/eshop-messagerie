package fr.formation;

import fr.formation.factory.RepositoryFactory;
import fr.formation.model.Message;
import fr.formation.model.Salon;
import fr.formation.repo.IMessageRepository;
import fr.formation.repo.ISalonRepository;
import fr.formation.repo.jpa.SalonRepositoryJpa;



public class ApplicationUtilisateur {

	public static void main(String[] args) {

		int choixMenu = 0;

		do {
			choixMenu = Menu.print();
			switch (choixMenu) {
			case 01:seConnecter();break;
			case 02:crerSalon();break;
			case 03:listerSalon();break;
			case 04:listerMsgSalon();break;
			case 05:envoyerMsgSalon();break;
			}
		} while (choixMenu != 0);
		Saisie.sc.close();
	}

	private static void seConnecter() {
			
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
			
	}

}
