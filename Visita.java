public class Visita {
    private Paziente paziente;
    private String data; // Gestione fissa "Oggi" come richiesto
    private String stato;
    private String noteMediche;

    public Visita(Paziente paziente) {
        this.paziente = paziente;
        this.data = "Oggi";
        this.stato = "prenotata";
        this.noteMediche = "Nessuna nota";
    }

    public void referta(String note) {
        this.stato = "effettuata";
        this.noteMediche = note;
    }

    public Paziente getPaziente() { return paziente; }
    public String getStato() { return stato; }

    @Override
    public String toString() {
        return "[" + data + "] " + paziente + " | Stato: " + stato + " | Note: " + noteMediche;
    }
}
