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
	ClienteService clienteService = new ClienteService();

	public void menu(Cliente cliente) {

		if (cliente.getEmailCliente().equals("admin") && cliente.getUsername().equals("admin")) {
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
			aggiungiCliente(scannerLine);
			break;
		case 2:
			eliminaCliente(scannerLine);
			break;
		case 3:
			clienteService.getDettagliClienti();
			break;
		case 4:
			modificaCliente(scannerLine);
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
			aggiungiProdotto(scannerInt, scannerLine);
			break;
		case 2:
			eliminaProdotto(scannerInt);
			break;
		case 3:
			prodottoService.getDettagliProdotti();
			break;
		case 4:
			modificaProdotto(scannerInt, scannerLine);
			break;
		}
	}

	
	public void modificaProdotto(Scanner scanner1, Scanner scanner2) {
		System.out.println("Inserisci codice prodotto da modificare");
		int id  = scanner1.nextInt();
		System.out.println("Inserisci nuovo nome");
		String nuovoNome = scanner2.nextLine(); 
		System.out.println("Inserisci nuova descrizione");
		String nuovaDescrizione = scanner2.nextLine(); 
		System.out.println("Inserisci nuovo prezzo");
		float nuovoPrezzo = scanner1.nextFloat();
		System.out.println("Inserisci nuova marca");
		String nuovaMarca = scanner2.nextLine();
		prodottoService.modificaProdotto(id, nuovoNome, nuovaDescrizione, nuovoPrezzo, nuovaMarca);
	}
	
	public void aggiungiProdotto(Scanner scanner1, Scanner scanner2) {
		System.out.println("Inserisci codice prodotto");
		int idProdotto = scanner1.nextInt();
		System.out.println("Inserisci nome prodotto");
		String nome = scanner2.nextLine();
		System.out.println("Inserisci marca prodotto");
		String marca = scanner2.nextLine(); 
		System.out.println("Inserisci descrizione prodotto");
		String descrizione = scanner2.nextLine(); 
		System.out.println("Inserisci prezzo prodotto");
		float prezzo = scanner1.nextFloat(); 
		System.out.println("Inserisci quantita prodotto");
		int qta = scanner1.nextInt();
		
		Prodotto prodotto = new Prodotto(idProdotto,nome,marca,descrizione,prezzo,qta);
		prodottoService.aggiungiProdotto(prodotto);
	}
	
	public void eliminaProdotto(Scanner scanner) {
		prodottoService.getDettagliProdotti();
		
		System.out.println("Inserisci codice prodotto da eliminare");
		int idProdotto = scanner.nextInt();
		
		Prodotto prodotto = prodottoService.getProdotto(idProdotto);
		if (prodotto != null) {
			prodottoService.eliminaProdotto(idProdotto);
		} else {
			System.out.println("Codice prodotto non trovato");
		}
	}
	
	public void aggiungiCliente(Scanner scanner) {
		System.out.println("Inserisci email cliente");
		String emailCliente = scanner.nextLine();
		System.out.println("Inserisci username cliente");
		String username = scanner.nextLine();
		System.out.println("Inserisci password cliente");
		String password = scanner.nextLine();
		System.out.println("Inserisci nome cliente");
		String nome = scanner.nextLine();
		System.out.println("Inserisci cognome cliente");
		String cognome = scanner.nextLine();
		System.out.println("Inserisci indirizzo cliente");
		String indirizzo = scanner.nextLine();

		Cliente cliente = new Cliente(emailCliente, username, password, nome, cognome, indirizzo);
		clienteService.aggiungiCliente(cliente);
	}

	public void modificaCliente(Scanner scanner) {
		System.out.println("Inserisci email cliente da modificare");
		String email = scanner.nextLine();
		System.out.println("Inserisci nuono nome  cliente");
		String nuovoNome = scanner.nextLine();
		System.out.println("Inserisci nuovo cognome cliente");
		String nuovoCognome = scanner.nextLine();
		System.out.println("Inserisci nuova email cliente");
		String nuovaEmail = scanner.nextLine();

		clienteService.modificaCliente(email, nuovoNome, nuovoCognome, nuovaEmail);
	}

	public void eliminaCliente(Scanner scanner) {
		System.out.println("Inserisci email cliente da eliminare");
		String email = scanner.nextLine();
		
		Cliente cliente = clienteService.getCliente(email);
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

		Prodotto prodotto = shopService.getProdottoNelCarrello(id);
		shopService.rimuoviProdottoDalCarrello(prodotto);

	}

	public void modificaCarrello(Scanner scanner) {
		shopService.getDettagliCarrello();
		System.out.println("inserisci codice prodotto da modificare");
		int id = scanner.nextInt();

		System.out.println("inserisci codice prodotto da modificare");
		scanner.nextLine(); // consumo la linea per pulire il buffer
		int qta = scanner.nextInt();

		Prodotto prodotto = shopService.getProdottoNelCarrello(id);
		shopService.modificaQuantitaProdotto(prodotto, qta);
	}
}