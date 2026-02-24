public class Paziente extends Persona {
    private String codiceFiscale, telefono;

    public Paziente(String nome, String cognome, String sesso, String dataNascita, String cf, String tel) {
        super(nome, cognome, sesso, dataNascita);
        this.codiceFiscale = cf;
        this.telefono = tel;
    }

    @Override
    public String toString() {
        return super.toString() + " (CF: " + codiceFiscale + " | Tel: " + telefono + ")";
    }
}
