package SportShop;

import java.util.List;
import java.util.ArrayList;

public class Carrello {
	List<Prodotto> carrello = new ArrayList<Prodotto>();

	public void aggiungiAlCarrello(Prodotto prodotto, int qta) {

		if (prodotto.getQuantita() >= qta) {
			prodotto.setQuantita(prodotto.getQuantita() - qta);
			carrello.add(new Prodotto(prodotto.getIdProdotto(), prodotto.getNome(), prodotto.getMarca(),
					prodotto.getDescrizione(), prodotto.getPrezzo(), qta));
		} else {
			System.out.println("Quantita` selezionata non disponibile per il prodotto: " + prodotto.getNome());
			System.out.println("provi ad effettuare un preordine per poter essere avvisato in caso di disponibilita`?");
		}
	}

	public void rimuoviDalCarrello(Prodotto prodotto) {
		Prodotto prodottoDaRimuovere = null;

		for (Prodotto prodottoNelCarrello : carrello) {
			if (prodotto.getIdProdotto() == prodottoNelCarrello.getIdProdotto()) {
				prodottoDaRimuovere = prodottoNelCarrello;
			}
		}
		if (prodottoDaRimuovere != null) {
			carrello.remove(prodottoDaRimuovere);
		} else if (prodottoDaRimuovere == null) {
			System.out.println("Prodotto selezionato non presente nel carrello");
		}
	}

	public void modificaQuantitaOrdinata(Prodotto prodotto, int qta) {
		Prodotto prodottoDaModificare = null;

		for (Prodotto prodottoNelCarrello : carrello) {
			if (prodotto.getIdProdotto() == prodottoNelCarrello.getIdProdotto()) {
				prodottoDaModificare = prodottoNelCarrello;
			}
		}
		if (prodottoDaModificare != null) {
			if(prodotto.getQuantita() > qta ) {
				prodottoDaModificare.setQuantita(qta);
			}
			else {
				System.out.println("Quantita non disponibile");
			}
		
		} else if (prodottoDaModificare == null) {
			System.out.println("Prodotto selezionato non presente nel carrello");
		}
	}
}
