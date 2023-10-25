package gestoreConnessioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GestoreConnessioni {
	
	private String url;
	private String user;
	private String pwd;
	
	private Connection conn;
	private ResultSet rs;
	
	public GestoreConnessioni() {
		
	}
	
	public GestoreConnessioni(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		stabilisciConnessione();
	}
	
	public void stabilisciConnessione() {
		stabilisciConnessione(getUrl(), getUser(), getPwd());
	}
	
	public void stabilisciConnessione(String url, String user, String pwd) {
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			if(conn != null)
				System.out.println("Connessione stabilita.");
			else
				System.out.println("Connessione fallita.");
			
		} catch(Exception e) {
			System.out.println("ERRORE!");
		}
	}
	
	public ResultSet eseguiStatementQuery(String query) {
		return eseguiStatementQuery(getConn(), query);
	}
	
	public ResultSet eseguiStatementQuery(Connection conn, String query) {
		try {
		Statement stmt = conn.createStatement();
		
		return stmt.executeQuery(query);
		} catch(Exception e) {
			System.out.println("Errore: non è stata eseguita la query");
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getResultSet() {
		return rs;
	}
	
	public void setResultSet(ResultSet rs) {
		this.rs = rs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Connection getConn() {
		return conn;
	}
}
