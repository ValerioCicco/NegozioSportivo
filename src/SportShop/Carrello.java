package SportShop;

import java.util.List;
import java.util.ArrayList;

public class Carrello {
	private List<Prodotto> carrello = new ArrayList<Prodotto>();

	public void aggiungiAlCarrello(Prodotto prodotto, int qta) {

		if (prodotto.getQuantita() >= qta) {
			prodotto.setQuantita(prodotto.getQuantita() - qta);
			carrello.add(new Prodotto(prodotto.getIdProdotto(), prodotto.getNome(), prodotto.getMarca(),
					prodotto.getDescrizione(), prodotto.getPrezzo(), qta));
			System.out.println("Prodotto: " + prodotto.getNome() + " aggiunto con successo al carrello");
		} else {
			System.out.println("Quantita` selezionata non disponibile per il prodotto: " + prodotto.getNome());
			System.out.println("provi ad effettuare un preordine per poter essere avvisato in caso di disponibilita`?");
		}
	}

	public void rimuoviDalCarrello(Prodotto prodotto) {

		Prodotto prodottoDaRimuovere = getProdotto(prodotto.getIdProdotto());

		if (prodottoDaRimuovere != null) {
			carrello.remove(prodottoDaRimuovere);
		} else if (prodottoDaRimuovere == null) {
			System.out.println("Prodotto selezionato non presente nel carrello");
		}
	}

	public void modificaQuantitaOrdinata(Prodotto prodotto, int qta) {

		Prodotto prodottoDaModificare = getProdotto(prodotto.getIdProdotto());

		if (prodottoDaModificare != null) {
			if (prodotto.getQuantita() > qta) {
				prodottoDaModificare.setQuantita(qta);
				System.out.println("Quantita` modificare correttamente:" + prodotto.getNome() + " Quantita: " + prodotto.getQuantita());
			} else {
				System.out.println("Quantita non disponibile");
			}

		} else if (prodottoDaModificare == null) {
			System.out.println("Prodotto selezionato non presente nel carrello");
		}
	}

	public Prodotto getProdotto(int idProdotto) {
		for (Prodotto prodottoNelCarrello : carrello) {
			if (prodottoNelCarrello.getIdProdotto() == idProdotto) {
				return prodottoNelCarrello;
			}
		}
		return null;
	}
	
	public double getTotale() {
        double totale = 0.0;
        for (Prodotto prodotto : carrello) {
            totale += prodotto.getPrezzo() * prodotto.getQuantita();
        }
        return totale;
    }
	
	 public String toString() {
	        StringBuilder sb = new StringBuilder();
	        for (Prodotto prodotto : carrello) {
	            sb.append(prodotto).append("\n");
	        }
	        sb.append("Totale: ").append(getTotale()).append("€");
	        return sb.toString();
	    }

	public List<Prodotto> getProdottiNelCarrello() {
		return carrello;
	}
}
