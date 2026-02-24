import java.util.ArrayList;

public class Segreteria {
    private ArrayList<Medico> medici;

    public Segreteria() {
        medici = new ArrayList<>();
    }

    public void aggiungiMedico(Medico m) { medici.add(m); }

    public void prenotaVisita(String nomePaziente, String data, String orario, int indiceMedico) {
        if (indiceMedico >= 0 && indiceMedico < medici.size()) {
            Medico m = medici.get(indiceMedico);
            Visita v = new Visita(nomePaziente, data, orario);
            m.aggiungiVisita(v);
            System.out.println("Prenotazione registrata con Dott. " + m.getCognome());
        }
    }

    public void cercaPrenotazione(String nomePaziente) {
        for (int i = 0; i < medici.size(); i++) {
            Medico m = medici.get(i);
            int nVisite = m.getPrenotazioni().size();
            for (int j = 0; j < nVisite; j++) {
                Visita v = m.getPrenotazioni().poll();
                if (v.getNomePaziente().equalsIgnoreCase(nomePaziente)) {
                    System.out.println("Trovata: " + v + " con Dott. " + m.getCognome());
                }
                m.getPrenotazioni().add(v);
            }
        }
    }
}
