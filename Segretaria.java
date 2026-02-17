import java.util.ArrayList;


public class Segreteria {


    private ArrayList<Medico> medici;

    public Segreteria() {
        medici = new ArrayList<Medico>();
    }


    public void aggiungiMedico(Medico m) {
        medici.add(m);
    }


    public void prenotaVisita(String nomePaziente, Medico medico) {

        Visita v = new Visita(nomePaziente); // crea una nuova visita

        medico.aggiungiVisita(v); // la aggiunge al medico scelto

        System.out.println("Visita prenotata con il Dottor " + medico.getCognome());
    }


    public void cercaPrenotazione(String nomePaziente) {

        // Scorre tutti i medici
        for (int i = 0; i < medici.size(); i++) {

            Medico m = medici.get(i); // prende il medico

            // Scorre tutte le prenotazioni del medico
            for (int j = 0; j < m.getPrenotazioni().size(); j++) {

                Visita v = m.getPrenotazioni().get(j); // prende la visita

                // Controlla se il nome coincide
                if (v.getNomePaziente().equals(nomePaziente)) {

                    System.out.println("Trovata visita con il Dottor " + m.getCognome());

                    System.out.println(v); // stampa la visita
                }
            }
        }
    }


    public void cancellaVisita(String nomePaziente) {


        for (int i = 0; i < medici.size(); i++) {

            Medico m = medici.get(i); // prende il medico

            //  rimuove la visita
            if (m.rimuoviVisita(nomePaziente)) {

                System.out.println("Visita cancellata.");

                return; // esce se cancellata
            }
        }

        // Se non trovata
        System.out.println("Visita non trovata o già effettuata.");
    }
}
