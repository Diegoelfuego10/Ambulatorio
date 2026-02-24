import java.util.LinkedList;
import java.util.Queue;

public class Medico extends Persona {
    private String specializzazione;
    private Queue<Visita> prenotazioni;

    public Medico(String nome, String cognome, String specializzazione) {
        super(nome, cognome);
        this.specializzazione = specializzazione;
        this.prenotazioni = new LinkedList<>();
    }

    public void aggiungiVisita(Visita v) {
        prenotazioni.add(v);
    }

    public void visualizzaPrenotazioni() {
        System.out.println("\nPrenotazioni Dott. " + getCognome());
        int quante = prenotazioni.size();
        for (int i = 0; i < quante; i++) {
            Visita v = prenotazioni.poll(); // Lo sfilo
            System.out.println(v);           // Lo mostro
            prenotazioni.add(v);            // Lo rimetto in fondo per non perderlo
        }
    }

    public boolean rimuoviVisita(String nomePaziente) {
        boolean rimossa = false;
        int quante = prenotazioni.size();
        for (int i = 0; i < quante; i++) {
            Visita v = prenotazioni.poll();
            // Se trovo il paziente e non è ancora stata effettuata e non ne ho già rimossa una
            if (v.getNomePaziente().equalsIgnoreCase(nomePaziente) && v.getStato().equals("prenotata") && !rimossa) {
                rimossa = true; 
                // NON lo riaggiungo: l'elemento è rimosso
            } else {
                prenotazioni.add(v);
            }
        }
        return rimossa;
    }

    public void effettuaProssimaVisita() {
        if (!prenotazioni.isEmpty()) {
            Visita v = prenotazioni.poll();
            v.setEffettuata();
            System.out.println("Visita completata per: " + v.getNomePaziente());
        } else {
            System.out.println("Coda vuota.");
        }
    }

    public Queue<Visita> getPrenotazioni() { return prenotazioni; }
}
