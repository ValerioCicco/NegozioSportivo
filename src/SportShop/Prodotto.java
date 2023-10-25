package SportShop;

public class Prodotto {

	private int idProdotto;
	private String nome;
	private String marca;
	private String descrizione;
	private float prezzo;
	private int qta;
	private boolean isPresent;
	
	public Prodotto(int idProdotto, String nome, String marca, String descrizione, float prezzo) {
		super();
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	public Prodotto(int idProdotto, String nome, String marca, String descrizione, float prezzo, int qta) {
		super();
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	
	

	public Prodotto(int idProdotto, String nome, String marca, String descrizione, float prezzo, int qta,
			boolean isPresent) {
		super();
		this.idProdotto = idProdotto;
		this.nome = nome;
		this.marca = marca;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.qta = qta;
		this.isPresent = isPresent;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isPresent() {
		return isPresent;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public int getQuantita() {
		return qta;
	}
	
	public void setQuantita(int quantita) {
		this.qta = quantita;
	}
	
	
	
	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}

	public String toString() {
        return "Codice: " + getIdProdotto() +
               ", Nome: " + getNome() +
               ", Descrizione: " + getDescrizione() +
               ", Prezzo: " + getPrezzo() +
               ", Marca: " + getMarca() +
               ", Quantità: " + getQuantita();
    }
	
}