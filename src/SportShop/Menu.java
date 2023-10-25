package SportShop;



import java.util.Scanner;


//MENU
public class Menu {

	Scanner scannerLine = new Scanner(System.in);
	Scanner scannerInt = new Scanner(System.in);
	

	public void menu(Cliente cliente) {

		if (cliente instanceof Admin) {
			System.out.println("Benvenuto admin");
			System.out.println("Scegli 1 per gestire gli utenti e 2 per gestire i prodotti");
			int responsePanel = scannerInt.nextInt();

			switch (responsePanel) {

			case 1:
				clienti();
				break;

			case 2:
				prodotti();
				break;

			}
		} else {
			System.out.println("Benvenuto cliente" + cliente.getNome());
			System.out.println(
					"Premi 1 per vedere il catalogo, 2 per aggiungere al carrello, 2 per modificare il carrello");
			int responseCarrello = scannerInt.nextInt();

			switch (responseCarrello) {

			case 1:
				// DAO VISUALIZZA CARRELLO
				break;
			case 2:
				// DAO AGGIUNTA CARRELLO
				break;
			case 3:
				// DAO MODIFICA CARRELLO
				break;
			}
		}

	}

	public void clienti() {

		System.out.println(
				"Scegli 1 per aggiungere un cliente, 2 per cancellarlo, 3 per vedere la lista, 4 per modificarlo");
		int response = scannerInt.nextInt();
		switch (response) {

		case 1:
			// aggiungere metodi DAO
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;
		}
	}

	public void prodotti() {
		System.out.println("Scegli 1 per aggiungere un prodotto, 2 per cancellarlo, 3 per vedere la lista, 4 per modificarlo");
		int response = scannerInt.nextInt();
		switch (response) {

		case 1:
			// AGGIUNGERE METODI DAO
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;
		}
	}


}