package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import SportShop.Prodotto;
import SportShop.ProdottoService;
import gestoreConnessioni.GestoreConnessioni;

public class ProdottoDAO {
	
	public static ArrayList<Prodotto> getAllProducts(GestoreConnessioni gc, ProdottoService ps) {
		String query = "SELECT * FROM prodotti";

		ResultSet rs = gc.eseguiStatementQuery(query);

		ArrayList<Prodotto> prodotti = (ArrayList<Prodotto>) ps.getProdotti();

		try {
			while (rs.next()) {
				int idProdotto = Integer.parseInt(rs.getString(1));
				String nome = rs.getString(2);
				String marca = rs.getString(3);
				String descrizione = rs.getString(4);
				float prezzo = Float.parseFloat(rs.getString(5));
				boolean isPresent = rs.getBoolean(6);
				int qta = Integer.parseInt(rs.getString(7));
				Prodotto prodotto = new Prodotto(idProdotto, nome, marca, descrizione, prezzo, qta, isPresent);
				prodotti.add(prodotto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prodotti;

	}

	public static void insertProduct(GestoreConnessioni gc, ProdottoService ps, Prodotto prodotto) {
		String query = ("INSERT INTO prodotti (idProdotto, nome, marca, descrizione, prezzo, isPresent, qta) "
				+ "VALUES (?, ?, ?, ?, ?, ?)");
		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			prstmt.setInt(1, prodotto.getIdProdotto());
			prstmt.setString(2, prodotto.getNome());
			prstmt.setString(3, prodotto.getMarca());
			prstmt.setString(4, prodotto.getDescrizione());
			prstmt.setFloat(5, prodotto.getPrezzo());
			prstmt.setBoolean(6, prodotto.isPresent());
			prstmt.setInt(7, prodotto.getQta());

			prstmt.execute();

			System.out.println("insert eseguito correttamente");

			ps.aggiungiProdotto(prodotto);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public boolean updateProduct(GestoreConnessioni gc, Prodotto prodotto) throws SQLException {
		String query = "UPDATE prodotti SET nome = ?, marca = ?, descrizione = ?, prezzo = ?, isPresent = ?, qta = ? WHERE idProdotto = ?";
		Connection conn = gc.getConn();
		PreparedStatement preparedStatement = conn.prepareStatement(query);

		try {
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getMarca());
			preparedStatement.setString(3, prodotto.getDescrizione());
			preparedStatement.setFloat(4, prodotto.getPrezzo());
			preparedStatement.setBoolean(5, prodotto.isPresent());
			preparedStatement.setInt(6, prodotto.getQta());
			preparedStatement.setInt(7, prodotto.getIdProdotto());

			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Modifica avvenuta con successo");
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public static void deleteAuto(GestoreConnessioni gc, ProdottoService ps, Prodotto prodotto) {
		String query = ("DELETE FROM prodotti WHERE id=?");

		try {
			Connection conn = gc.getConn();

			PreparedStatement prstmt = conn.prepareStatement(query);

			int id = prodotto.getIdProdotto();

			prstmt.setString(1, id + "");

			System.out.println("Delete eseguita correttamente");

			prstmt.execute();
			
			ps.eliminaProdotto(id);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
