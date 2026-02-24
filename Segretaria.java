import java.util.ArrayList;
import java.util.Queue;

public class Segreteria {
    // Lista che contiene i 3 medici
    private ArrayList<Medico> medici = new ArrayList<>();

    // Metodo per registrare i medici nel sistema (fino a un massimo di 3)
    public void aggiungiMedico(Medico m) {
        if (medici.size() < 3) medici.add(m);
    }

    public ArrayList<Medico> getMedici() { return medici; }

    // Scorre tutti i medici e le rispettive code per mostrare chi ha prenotato
    public void mostraTuttePrenotazioni() {
        System.out.println("\n Lista prenotazioni: ");
        boolean trovate = false; // Flag per capire se il sistema è vuoto o meno

        for (Medico m : medici) {
            for (Visita v : m.getCodaVisite()) { // Ciclo per ogni visita nella coda di quel medico
                // Stampa il cognome del paziente e il medico assegnato
                System.out.println("- " + v.getPaziente().getCognome() + " (Medico: " + m.getCognome() + ")");
                trovate = true;
            }
        }
        if (!trovate) System.out.println("Nessuna prenotazione trovata.");
    }

    public void cancellaVisita(String cognomePaziente) {
        boolean rimosso = false;

        for (Medico m : medici) {
            Queue<Visita> coda = m.getCodaVisite();
            int size = coda.size(); // Salviamo la dimensione attuale per il ciclo

            // Estraiamo tutti gli elementi e li reinseriamo solo se non sono quelli da cancellare
            for (int i = 0; i < size; i++) {
                Visita v = coda.poll(); // Estrae l'elemento in testa

                // Se il cognome corrisponde e non abbiamo ancora rimosso
                if (!rimosso && v.getPaziente().getCognome().equalsIgnoreCase(cognomePaziente)) {
                    System.out.println("Cancellazione effettuata per: " + cognomePaziente);
                    rimosso = true; // Segnamo come rimosso
                } else {
                    coda.add(v); // Se non corrisponde, lo rimettiamo in fondo alla coda
                }
            }
        }
        // Se dopo aver girato tutti i medici non abbiamo trovato il cognome
        if (!rimosso) System.out.println("Nessuna prenotazione trovata per il cognome: " + cognomePaziente);
    }


    public void cercaPrenotazioni(String cognomePaziente) {
        boolean trovato = false;
        for (Medico m : medici) {
            for (Visita v : m.getCodaVisite()) {
                // Confronta il cognome ignorando maiuscole e minuscole
                if (v.getPaziente().getCognome().equalsIgnoreCase(cognomePaziente)) {
                    System.out.println("Trovato: " + v + " con Dott. " + m.getCognome());
                    trovato = true;
                }
            }
        }
        if (!trovato) System.out.println("Nessun risultato per: " + cognomePaziente);
    }
}
