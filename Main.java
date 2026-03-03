package it.edu.cannizzaro.quartab25.poliambulatorio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Segreteria segreteria = new Segreteria();
        segreteria.aggiungiMedico(new Medico("Luca", "Gallina", "M", "10/05/1975", "Cardiologia"));
        segreteria.aggiungiMedico(new Medico("Sara", "Licocci", "F", "22/11/1982", "Dermatologia"));
        segreteria.aggiungiMedico(new Medico("Marco", "Ceracchi", "M", "15/02/1970", "Pediatria"));
        String utente = "";
        while (!utente.equalsIgnoreCase("esci")) {
            System.out.println("\n POLIAMBULATORIO");
            System.out.println("Accedi come (segreteria / medico / esci");
            utente = in.next().toLowerCase();

            // Controllo del ruolo per l'accesso ai sottomenu
            if (utente.equals("segreteria")) {
                gestisciSegreteria(segreteria, in); // Avvia la funzione per la segretaria
            } else if (utente.equals("medico")) {
                gestisciMedico(segreteria, in); // Avvia la funzione per il medico specifico
            }
        }
    }

    private static void gestisciSegreteria(Segreteria s, Scanner in) {
        String azione = "";
        //resta nel menu segreteria finche non viene digitato "logout";

        while (!azione.equals("logout")) {
            System.out.println("\n [SEGRETERIA] PRENOTA | CERCA | CANCELLA | LOGOUT");
            azione = in.next().toLowerCase();

            if (azione.equals("prenota")) {
                System.out.print("Nome: ");
                String n = in.next();
                System.out.print("Cognome: ");
                String c = in.next();
                System.out.print("Sesso: ");
                String sesso = in.next();
                System.out.print("Data di nascita: ");
                String dN = in.next();
                System.out.print("Codice fiscale: ");
                String cf = in.next();
                System.out.print("Telefono: ");
                String tel = in.next();

                System.out.println("Scegli medico: ");
                for (int i = 0; i < s.getMedici().size(); i++) {
                    System.out.println((i + 1 + ": Dott" + s.getMedici().get(i).getCognome() + "(" + s.getMedici().get(i).getSpecializzazione() + ")"));
                    int mScelto = in.nextInt();
                    // crea un nuovo oggetto Paziente e lo aggiunge come visita a un medico specifico.
                    s.getMedici().get(mScelto).aggiungiVisita(new Visita(new Paziente(n, c, sesso, dN, cf, tel)));
                    System.out.println("Visita prenotata per oggi");
                }
            } else if (azione.equals("cerca")) {
                System.out.print("Cognome: ");
                s.cercaPrenotazioni(in.next());
            } else if (azione.equals("cancella")) {
                s.mostraTuttePrenotazioni();
                System.out.print("Cognome da eliminare: ");
                s.cancellaVisita(in.next());
            }
        }

    }

    private static void gestisciMedico(Segreteria s, Scanner in) {

        System.out.print("Cognome medico: ");
        String cognomeM = in.next();

        Medico m = null;
        for (Medico med : s.getMedici()) {
            if (med.getCognome().equalsIgnoreCase(cognomeM)) {
                m = med;
                break;
            }
        }

// Se il medico esiste nel sistema, mostra il suo menu dedicato
        if (m != null) {
            String azione;
            do {
                System.out.println("\n[DOTT. " + m.getCognome().toUpperCase() + "] AGENDA | VISITA | LOGOUT");
                azione = in.next().toLowerCase().trim();

                switch (azione) {
                    case "agenda":
                        m.visualizzaAgenda();
                        break;

                    case "visita":
                        if (m.getCodaVisite().isEmpty()) {
                            System.out.println("Coda vuota");
                        } else {
                            System.out.print("Referto: ");
                            in.nextLine();  // Pulisce il buffer dopo "visita"
                            String referto = in.nextLine();

                            
                            if (m.effettuaProssimaVisita(referto) != null) {
                                System.out.println("Visita completata.");
                            } else {
                                System.out.println("Errore: visita non completata.");
                            }
                        }
                        break;

                    case "logout":
                        System.out.println("Logout effettuato.");
                        break;
                }
            } while (!azione.equals("logout"));
        } else {
            System.out.println("Medico non trovato.");
        }

    }
}

