public class Visita {
    private String nomePaziente;
    private String data;
    private String orario;
    private String stato; // "prenotata" o "effettuata"

    public Visita(String nomePaziente, String data, String orario) {
        this.nomePaziente = nomePaziente;
        this.data = data;
        this.orario = orario;
        this.stato = "prenotata";
    }

    public void setEffettuata() {
        this.stato = "effettuata";
    }

    public String getNomePaziente() { return nomePaziente; }
    public String getStato() { return stato; }

    @Override
    public String toString() {
        return "[Paziente: " + nomePaziente + " | Data: " + data + " | Ora: " + orario + " | Stato: " + stato + "]";
    }
}
