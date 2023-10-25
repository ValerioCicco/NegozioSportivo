package SportShop;

import java.util.List;
import java.util.ArrayList;

public class ProdottoService {
	private List<Prodotto> prodotti = new ArrayList<Prodotto>();

	//Aggiungi nuovo prodotto
	public void aggiungiProdotto(Prodotto prodotto) {
		prodotti.add(prodotto);
		System.out.println("Prodotto aggiunto con successo");
	}

	//Modifica i dettagli di un prodotto
	public void modificaProdotto(int id, String nuovoNome, String nuovaDescrizione, float nuovoPrezzo,
			String nuovaMarca) {
		for (Prodotto prodotto : prodotti) {
			if (prodotto.getIdProdotto() == (id)) {
				prodotto.setNome(nuovoNome);
				prodotto.setDescrizione(nuovaDescrizione);
				prodotto.setPrezzo(nuovoPrezzo);
				prodotto.setMarca(nuovaMarca);
				System.out.println("Prodotto modificato con successo.");
				return;
			}
		}
		System.out.println("Prodotto non trovato con il codice specificato.");
	}

	//Elimina un prodotto
	public void eliminaProdotto(int id) {
		Prodotto prodottoDaEliminare = null;
		for (Prodotto prodotto : prodotti) {
			if (prodotto.getIdProdotto() == id) {
				prodottoDaEliminare = prodotto;
				break;
			}
		}
		if (prodottoDaEliminare != null) {
			prodotti.remove(prodottoDaEliminare);
			System.out.println("Prodotto eliminato con successo.");
		} else {
			System.out.println("Prodotto non trovato con il codice specificato.");
		}
	}

	 // Modifica la quantità di un prodotto
    public void modificaQuantitaProdotto(int id, int nuovaQuantita) {
        for (Prodotto prodotto : prodotti) {
            if (prodotto.getIdProdotto() == id) {
                if (nuovaQuantita >= 0) {
                    prodotto.setQuantita(nuovaQuantita);
                } else {
                    System.out.println("La quantità non può essere negativa.");
                }
                return;
            }
        }
        System.out.println("Prodotto non trovato con il codice specificato.");
    }
    
    // Mostra la lista dei prodotti
    public List<Prodotto> getProdotti() {
        return prodotti;
    }
    
    //Cerca singolo prodotto
    public Prodotto getProdotto(int id) {
    	for (Prodotto prodotto : prodotti) {
			if (prodotto.getIdProdotto() == id) {
				return prodotto;
			}
		}
		return null;
    }
    
    //Mostra i dettagli dei prodotti su schermo
    public void getDettagliProdotti() {
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto.toString());
        }
    }
}
