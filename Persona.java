public class Persona {
    protected String nome, cognome, sesso, dataDiNascita;

    public Persona(String nome, String cognome, String sesso, String dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + sesso + ", nato/a il " + dataDiNascita + ")";
    }
}
