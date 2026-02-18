import java.util.ArrayList;

public class Segreteria {

    private ArrayList<Medico> medici;

    public Segreteria() {
        medici = new ArrayList<>();
    }

    public void aggiungiMedico(Medico m) {
        medici.add(m);
    }

    public void prenotaVisita(String nomePaziente, String data, String orario, Medico medico) {

        Visita v = new Visita(nomePaziente, data, orario);
        medico.aggiungiVisita(v);

        System.out.println("Visita prenotata con il Dottor " + medico.getCognome());
    }

    public void cercaPrenotazione(String nomePaziente) {

        for (int i = 0; i < medici.size(); i++) {

            Medico m = medici.get(i);

            int size = m.getPrenotazioni().size();

            for (int j = 0; j < size; j++) {

                Visita v = m.getPrenotazioni().poll();

                if (v.getNomePaziente().equals(nomePaziente)) {

                    System.out.println("Trovata visita con il Dottor " + m.getCognome());
                    System.out.println(v);
                }

                m.getPrenotazioni().add(v); // reinserisco
            }
        }
    }

    public void cancellaVisita(String nomePaziente) {

        for (int i = 0; i < medici.size(); i++) {

            if (medici.get(i).rimuoviVisita(nomePaziente)) {
                System.out.println("Visita cancellata.");
                return;
            }
        }

        System.out.println("Visita non trovata o già effettuata.");
    }
}
