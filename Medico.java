import java.util.LinkedList;
import java.util.Queue;


public class Medico extends Persona {
    private String specializzazione;
    private Queue<Visita> codaVisite;


    public Medico(String nome, String cognome, String sesso, String dataNascita, String specializzazione) {

        super(nome, cognome, sesso, dataNascita);
        this.specializzazione = specializzazione;

        this.codaVisite = new LinkedList<>();
    }

    public String getSpecializzazione() { return specializzazione; }


    public void aggiungiVisita(Visita v) {
        codaVisite.add(v); // Aggiunge l'elemento in coda
    }

    public Visita effettuaProssimaVisita(String note) {
        // Controllo di sicurezza: se la coda è vuota, ritorna null
        if (codaVisite.isEmpty()) return null;

        // poll() estrae e rimuove il primo paziente della coda
        Visita v = codaVisite.poll();

        // Chiama il metodo referta della classe Visita per cambiare stato e aggiungere note
        v.referta(note);
        return v; // Ritorna la visita completata
    }

    // Metodo per stampare a video tutte le prenotazioni correnti
    public void visualizzaAgenda() {
        System.out.println("\nAgenda Dott. " + cognome + " (" + specializzazione + ")");

        // Verifica se ci sono pazienti nell'elenco
        if (codaVisite.isEmpty()) {
            System.out.println("Nessuna visita in attesa.");
        } else {
            // Ciclo for-each per scorrere la coda senza rimuovere gli elementi
            for (Visita v : codaVisite) {
                System.out.println(v); // Stampa i dettagli della visita (grazie al toString di Visita)
            }
        }
    }

    public Queue<Visita> getCodaVisite() { return codaVisite; }
}
