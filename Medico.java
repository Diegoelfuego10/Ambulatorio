import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Medico extends Persona {

    String specializzazione;
    Queue<Prenotazione> prenotazioni = new LinkedList<>();

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void aggiungiPrenotazione(Prenotazione p) {
        prenotazioni.add(p);   // enqueue
    }

    public void visualizzaPrenotazioni() {
        for (Prenotazione p : prenotazioni) {
            System.out.println(p);
        }
    }

    public void effettuaVisita() {
        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione");
        } else {
            Prenotazione p = prenotazioni.poll(); // dequeue
            p.setEffettuata(true);
            System.out.println("Visita effettuata: " + p);
        }
    }

    public void richiestaDati(Scanner scanner) {
        super.richiestaDati(scanner);
        System.out.printf("Inserisci specializzazione: ");
        setSpecializzazione(scanner.next());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", specializzazione='" + specializzazione + '\'';
    }
}
