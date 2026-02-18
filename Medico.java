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

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void aggiungiVisita(Visita v) {
        prenotazioni.add(v); // inserimento in coda
    }

    // Il medico effettua la prossima visita (FIFO)
    public void effettuaProssimaVisita() {

        if (!prenotazioni.isEmpty()) {

            Visita v = prenotazioni.poll(); // rimuove il primo
            v.setEffettuata();

            System.out.println("Visita effettuata: " + v);

        } else {
            System.out.println("Nessuna visita in coda.");
        }
    }

    public void visualizzaPrenotazioni() {

        System.out.println("\nPrenotazioni del Dottor "
                + getCognome() + " (" + specializzazione + ")");

        int size = prenotazioni.size();

        for (int i = 0; i < size; i++) {

            Visita v = prenotazioni.poll(); // tolgo
            System.out.println(v);          // stampo
            prenotazioni.add(v);           // reinserisco
        }
    }

    public boolean rimuoviVisita(String nomePaziente) {

        boolean rimossa = false;

        for (int i = 0; i < prenotazioni.size; i++) {

            Visita v = prenotazioni.poll();

            if (v.getNomePaziente().equals(nomePaziente)
                    && v.getStato().equals("prenotata")
                    && !rimossa) {

                rimossa = true; // NON la reinserisco (quindi eliminata)

            } else {
                prenotazioni.add(v); // la rimetto in coda
            }
        }

        return rimossa;
    }
}
