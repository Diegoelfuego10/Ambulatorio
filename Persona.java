import java.util.Date;
import java.util.Scanner;

public class Persona {
    String nome;
    String cognome;
    String sesso;
    String dataDiNascita;


    public void setNome(String nome){
        this.nome=nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome
            () {
        return nome;
    }

    public String getCognome
            () {
        return cognome;
    }

    public String getSesso
            () {
        return sesso;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public String toString() {
        return "Persona" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", sesso='" + sesso + '\'';
    }

    public boolean equals (Object o) {
        if (o == this) return true;
        if (!(o instanceof Persona)) {
            return false;
        }


        Persona persona = (Persona) o;

        return persona.getNome().equals(this.nome) &&
                persona.getCognome().equals(this.cognome) &&
                persona.getSesso().equals(this.sesso);
    }

    public void richiestaDati(Scanner scanner){


        System.out.printf("Persona " );

        System.out.printf("Inserisci nome");
        setNome(scanner.next());


        System.out.printf("Inserisci cognome");
        setCognome(scanner.next());


        System.out.printf("Inserisci sesso");
        setSesso(scanner.next());


    }

}