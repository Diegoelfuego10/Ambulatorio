import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Segreteria segreteria = new Segreteria();


        segreteria.aggiungiMedico(new Medico("Marco", "Rossi", "M", "10/05/1975", "Cardiologia"));
        segreteria.aggiungiMedico(new Medico("Sara", "Bianchi", "F", "22/11/1982", "Dermatologia"));
        segreteria.aggiungiMedico(new Medico("Luca", "Verdi", "M", "15/02/1970", "Pediatria"));

        String utente = "";

        while (!utente.equalsIgnoreCase("esci")) {
            System.out.println("\n POLIAMBULATORIO");
            System.out.print("Accedi come (segreteria / medico / esci): ");
            utente = in.next().toLowerCase();

            // Controllo del ruolo per l'accesso ai sottomenu
            if (utente.equals("segreteria")) {
                gestisciSegreteria(segreteria, in); // Avvia la logica per la segretaria
            } else if (utente.equals("medico")) {
                gestisciMedico(segreteria, in); // Avvia la logica per il medico specifico
            }
        }
    }


    private static void gestisciSegreteria(Segreteria s, Scanner in) {
        String azione = "";
        // Resta nel menu segreteria finché non viene digitato 'logout'
        while (!azione.equals("logout")) {
            System.out.println("\n[SEGRETERIA] PRENOTA | CERCA | CANCELLA | LOGOUT");
            azione = in.next().toLowerCase();

            if (azione.equals("prenota")) {

                System.out.print("Nome: "); String n = in.next();
                System.out.print("Cognome: "); String c = in.next();
                System.out.print("Sesso: "); String sex = in.next();
                System.out.print("Data Nascita: "); String dN = in.next();
                System.out.print("CF: "); String cf = in.next();
                System.out.print("Tel: "); String tel = in.next();

                // Mostra l'elenco dei medici
                System.out.println("Scegli Medico:");
                for (int i=0; i<s.getMedici().size(); i++)
                    System.out.println(i + ": Dott. " + s.getMedici().get(i).getCognome() + " (" + s.getMedici().get(i).getSpecializzazione() + ")");

                // Legge l'indice del medico scelto
                int mIdx = in.nextInt();
                // Crea la Visita per il Paziente e la aggiunge alla Queue del medico selezionato
                s.getMedici().get(mIdx).aggiungiVisita(new Visita(new Paziente(n,c,sex,dN,cf,tel)));
                System.out.println("Prenotata per oggi.");

            } else if (azione.equals("cerca")) {
                // Cerca una prenotazione in tutte le liste dei medici tramite il cognome
                System.out.print("Cognome: "); s.cercaPrenotazioni(in.next());
            } else if (azione.equals("cancella")) {
                // Mostra prima l'elenco
                s.mostraTuttePrenotazioni();
                System.out.print("Cognome da eliminare: "); s.cancellaVisita(in.next());
            }
        }
    }


    private static void gestisciMedico(Segreteria s, Scanner in) {
        // Simulazione login: il medico inserisce il suo cognome per accedere
        System.out.print("Cognome Medico: ");
        String cognomeM = in.next();
        Medico m = null;
        // Ricerca l'oggetto Medico corrispondente nella lista dei medici della segreteria
        for (Medico med : s.getMedici()) if (med.getCognome().equalsIgnoreCase(cognomeM)) m = med;

        // Se il medico esiste nel sistema, mostra il suo menu dedicato
        if (m != null) {
            String azione = "";
            while (!azione.equals("logout")) {
                System.out.println("\n[DOTT. " + m.getCognome().toUpperCase() + "] AGENDA | VISITA | LOGOUT");
                azione = in.next().toLowerCase();

                if (azione.equals("agenda")) {
                    m.visualizzaAgenda(); // Mostra i pazienti in coda per quel medico
                }
                else if (azione.equals("visita")) {

                    if (m.getCodaVisite().isEmpty()) System.out.println("Coda vuota");
                    else {
                        System.out.print("Referto: ");
                        in.nextLine();
                        // Estrae il primo paziente dalla coda (FIFO) e salva il referto inserito
                        m.effettuaProssimaVisita(in.nextLine());
                        System.out.println("Visita completata.");
                    }
                }
            }
        } else System.out.println("Medico non trovato.");
    }
}
