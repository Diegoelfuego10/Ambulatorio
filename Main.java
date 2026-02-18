import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Poliambulatorio poliambulatorio = new Poliambulatorio();
        Segreteria segreteria = poliambulatorio.getSegreteria();

        // Aggiungi alcuni medici
        Medico medico1 = new Medico("Mario", "Rossi", "Cardiologia");
        Medico medico2 = new Medico("Luca", "Bianchi", "Pediatria");
        Medico medico3 = new Medico("Giulia", "Verdi", "Neurologia");
        segreteria.aggiungiMedico(medico1);
        segreteria.aggiungiMedico(medico2);
        segreteria.aggiungiMedico(medico3);

        Scanner scanner = new Scanner(System.in);
        int scelta = 0;
        while (true) {
            System.out.println("Benvenuto nel sistema di gestione del poliambulatorio");
            System.out.println("1. Segreteria");
            System.out.println("2. Medico");
            System.out.println("3. Esci");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    menuSegreteria(segreteria, scanner);
                    break;
                case 2:
                    menuMedico(segreteria, scanner);
                    break;
                case 3:
                    System.out.println("Arrivederci!");
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    private static void menuSegreteria(Segreteria segreteria, Scanner scanner) {
        int scelta = 0;
        while (true) {
            System.out.println("Menu Segreteria");
            System.out.println("1. Prenota visita");
            System.out.println("2. Cerca prenotazione");
            System.out.println("3. Cancella prenotazione");
            System.out.println("4. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome del paziente:");
                    String nomePaziente = scanner.nextLine();
                    System.out.println("Inserisci il nome del medico:");
                    String nomeMedico = scanner.nextLine();
                    // ... prenota la visita ...
                    break;
                case 2:
                    System.out.println("Inserisci il nome del paziente:");
                    String nomePazienteCerca = scanner.nextLine();
                    segreteria.cercaPrenotazione(nomePazienteCerca);
                    break;
                case 3:
                    System.out.println("Inserisci il nome del paziente:");
                    String nomePazienteCancella = scanner.nextLine();
                    segreteria.cancellaVisita(nomePazienteCancella);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }

    private static void menuMedico(Segreteria segreteria, Scanner scanner) {
        System.out.println("Inserisci il nome del medico:");
        String nomeMedico = scanner.nextLine();
        Medico medico = null;
        for (Medico m : segreteria.getMedici()) {
            if (m.getNome().equals(nomeMedico)) {
                medico = m;
                break;
            }
        }
        if (medico == null) {
            System.out.println("Medico non trovato");
            return;
        }

        int scelta = 0;
        while (true) {
            System.out.println("Menu Medico");
            System.out.println("1. Visualizza prenotazioni");
            System.out.println("2. Inserisci esito visita");
            System.out.println("3. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    medico.visualizzaPrenotazioni();
                    break;
                case 2:
                    System.out.println("Inserisci il nome del paziente:");
                    String nomePaziente = scanner.nextLine();
                    // ... inserisci esito visita ...
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}