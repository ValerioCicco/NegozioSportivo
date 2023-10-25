package SportShop;

import java.util.List;

public class ShopService {
    private Carrello carrello;

    public ShopService(Carrello carrello) {
        this.carrello = carrello;
    }

    public void aggiungiProdottoAlCarrello(Prodotto prodotto, int quantita) {
        carrello.aggiungiAlCarrello(prodotto, quantita);
    }

    public void rimuoviProdottoDalCarrello(Prodotto prodotto) {
        carrello.rimuoviDalCarrello(prodotto);
    }

    public void modificaQuantitaProdotto(Prodotto prodotto, int quantita) {
        carrello.modificaQuantitaOrdinata(prodotto, quantita);
    }

    public List<Prodotto> getProdottiNelCarrello() {
        return carrello.getProdottiNelCarrello();
    }
    
    public Prodotto getProdottoNelCarrello(int id) {
    	return carrello.getProdotto(id);
    }

    public double getTotaleCarrello() {
        return carrello.getTotale();
    }
    
    public String getDettagliCarrello() {
    	return carrello.toString();
    }
}