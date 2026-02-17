import java.util.ArrayList;


public class Medico extends Persona {


    private String specializzazione;

    // Lista che contiene tutte le visite (prenotazioni) del medico
    private ArrayList<Visita> prenotazioni;


    public Medico(String nome, String cognome, String specializzazione) {
        super(nome, cognome);
        this.specializzazione = specializzazione;
        this.prenotazioni = new ArrayList<Visita>();
    }


    public String getSpecializzazione() {
        return specializzazione;
    }

    // Metodo che restituisce la lista delle prenotazioni
    public ArrayList<Visita> getPrenotazioni() {
        return prenotazioni;
    }

    ì
    public void aggiungiVisita(Visita v) {
        prenotazioni.add(v); // Inserisce la visita nella lista
    }


    public void visualizzaPrenotazioni() {

        // Stampa il nome del medico e la sua specializzazione
        System.out.println("Prenotazioni del Dottor " + getCognome() + "(" + specializzazione + ")");

        // Ciclo che scorre tutte le visite nella lista
        for (int i = 0; i < prenotazioni.size(); i++) {

            // Stampa la visita alla posizione i
            System.out.println(prenotazioni.get(i));
        }
    }
}
