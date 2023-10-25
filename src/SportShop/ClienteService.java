package SportShop;

import java.util.List;
import java.util.ArrayList;

public class ClienteService {
    private List<Cliente> clienti = new ArrayList<>();
    
    // Aggiungi un nuovo cliente
    public void aggiungiCliente(Cliente cliente) {
        clienti.add(cliente);
        System.out.println("Cliente aggiunto con successo.");
    }

    // Rimuovi un cliente
    public void eliminaCliente(String email) {
        Cliente clienteDaEliminare = null;
        for (Cliente cliente : clienti) {
            if (cliente.getEmailCliente().equals(email)) {
                clienteDaEliminare = cliente;
                break;
            }
        }
        if (clienteDaEliminare != null) {
            clienti.remove(clienteDaEliminare);
            System.out.println("Cliente eliminato con successo.");
        } else {
            System.out.println("Cliente non trovato con il codice specificato.");
        }
    }

    // Modifica i dettagli di un cliente
    public void modificaCliente(String email, String nuovoNome, String nuovoCognome, String nuovaEmail) {
        for (Cliente cliente : clienti) {
            if (cliente.getEmailCliente().equals(email)) {
                cliente.setNome(nuovoNome);
                cliente.setCognome(nuovoCognome);
                cliente.setEmailCliente(nuovaEmail);
                System.out.println("Dati del cliente modificati con successo.");
                return;
            }
        }
        System.out.println("Cliente non trovato con il codice specificato.");
    }

    // Restituisci la lista dei clienti
    public List<Cliente> getListaClienti() {
        return clienti;
    }
    
    public Cliente getCliente(String email) {
    	for (Cliente cliente : clienti) {
            if (cliente.getEmailCliente().equals(email)) {
            	return cliente;
            }
    	}
    	return null;
    }
    
    // Metodo per visualizzare i dettagli di tutti i clienti
    public void getDettagliClienti() {
        for (Cliente cliente : clienti) {
            System.out.println(cliente.toString());
        }
    }
}