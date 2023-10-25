package SportShop;


public class Cliente {
	private String emailCliente;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private String indirizzo;
	
	public Cliente(String emailCliente, String username, String password, String nome, String cognome,
			String indirizzo) {
		this.emailCliente = emailCliente;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String toString() {
        return "Username: " + getUsername() +
               ", Nome: " + getNome() +
               ", Cognome: " + getCognome() +
               ", Email: " + getEmailCliente();
    }

	
}	
