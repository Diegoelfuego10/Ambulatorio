public class Visita {
    private String nomePaziente;
    private String data;
    private String ora;
    private String stato;

    public Visita(String nomePaziente, String data, String ora) {
        this.nomePaziente = nomePaziente;
        this.data = data;
        this.ora = ora;
        this.stato = "prenotata";
    }

    public String getNomePaziente() {
        return nomePaziente;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Visita di " + nomePaziente + " il " + data + " alle " + ora + " - Stato: " + stato;
    }
}