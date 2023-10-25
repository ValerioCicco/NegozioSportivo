package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SportShop.Cliente;
import SportShop.ClienteService;
import SportShop.Prodotto;
import SportShop.ProdottoService;
import gestoreConnessioni.GestoreConnessioni;

public class ClienteDAO {

	public static ArrayList<Cliente> getAllClients(GestoreConnessioni gc, ClienteService cs) {
		String query = "SELECT * FROM clienti";

		ResultSet rs = gc.eseguiStatementQuery(query);

		ArrayList<Cliente> clienti = (ArrayList<Cliente>) cs.getListaClienti();

		try {
			while (rs.next()) {
				String emailCliente = rs.getString(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String nome = rs.getString(4);
				String cognome = rs.getString(5);
				String indirizzo = rs.getString(6);
				Cliente cliente = new Cliente(emailCliente, username,password,nome,cognome, indirizzo);
				clienti.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clienti;

	}
	
}
