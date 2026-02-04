public class Prenotazione {

    Cittadino paziente;
    Medico medico;
    String data;
    boolean effettuata;

    public Prenotazione(Cittadino paziente, Medico medico, String data) {
        this.paziente = paziente;
        this.medico = medico;
        this.data = data;
        this.effettuata = false;
    }

    public void setEffettuata(boolean effettuata) {
        this.effettuata = effettuata;
    }

    public boolean isEffettuata() {
        return effettuata;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "paziente=" + paziente +
                ", medico=" + medico.getNome() +
                ", data='" + data + '\'' +
                ", effettuata=" + effettuata +
                '}';
    }
}
