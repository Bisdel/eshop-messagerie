package fr.formation;

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
				
	}

	private static void listerSalon() {
				
	}

	private static void listerMsgSalon() {
			
	}

	private static void envoyerMsgSalon() {
			
	}

}
