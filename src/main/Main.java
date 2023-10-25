package main;

import java.util.ArrayList;
import java.util.List;

import SportShop.Cliente;
import SportShop.Menu;
import SportShop.Prodotto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("KTM");
		 List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Menu menu = new Menu();
		Cliente cliente = new Cliente("admin", "admin", "admin", "admin0", "admin", "admin");
		menu.menu(cliente);
	}

}
