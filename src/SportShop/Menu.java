package SportShop;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//MENU
public class Menu {

	Scanner scannerLine = new Scanner(System.in);
	Scanner scannerInt = new Scanner(System.in);
	private ShopService shopService;
	private ProdottoService prodottoService;
	private ClienteService clienteService;

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
					"Premi 1 per vedere il catalogo, 2 per aggiungere al carrello, 3 per eliminare un articolo dal carrello,"
					+ "  4 per modificare le quantita` nel carrello, 5 per visualizzare il carrello");
			int responseCarrello = scannerInt.nextInt();

			switch (responseCarrello) {

			case 1:
				// DAO VISUALIZZA CARRELLO
				prodottoService.getDettagliProdotti();
				break;
			case 2:
				// DAO AGGIUNTA CARRELLO
				aggiungiAlCarrello(scannerInt);
				break;
			case 3:
				// DAO MODIFICA CARRELLO
				eliminaCarrello(scannerInt);
				break;
			case 4:
				// DAO MODIFICA CARRELLO
				modificaCarrello(scannerInt);
				break;
			case 5:
				// DAO MODIFICA CARRELLO
				shopService.getDettagliCarrello();
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
		System.out.println(
				"Scegli 1 per aggiungere un prodotto, 2 per cancellarlo, 3 per vedere la lista, 4 per modificarlo");
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

	public void aggiungiAlCarrello(Scanner scanner) {
		prodottoService.getDettagliProdotti();

		System.out.println("Seleziona Codice prodotto da aggiungere al carrello");
		int id = scanner.nextInt();

		System.out.println("Seleziona quantita da aggiungere al carrello");
		int qta = scanner.nextInt();

		Prodotto prodotto = prodottoService.getProdotto(id);
		if (prodotto != null) {
			shopService.aggiungiProdottoAlCarrello(prodotto, qta);
		} else if (prodotto == null) {
			System.out.println("Prodotto non trovato, inserire codice prodotto valido");
			aggiungiAlCarrello(scanner);
		}

		
		// implementare una ricerca di prodotto in base agli attributi
		// implementare le statistiche dei prodotti venduti (decidiamo noi)
	}
	
	public void eliminaCarrello(Scanner scanner) {
		shopService.getDettagliCarrello();
		
		System.out.println("inserisci Codice prodotto da eliminare");
		int id = scanner.nextInt();
		
		
		
	}
	
	public void modificaCarrello(Scanner scanner) {
		shopService.getDettagliCarrello();
		System.out.println("Premi 1 per eliminare un prodotto dal carrello, 2 per");
	}
}