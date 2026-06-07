import entities.Audio;
import entities.ElementoMultimediale;
import entities.Immagine;
import entities.Video;
import interfaces.NonRiproducibile;
import interfaces.Riproducibile;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // ARRAY per memorizzare i 5 elementi
    ElementoMultimediale[] playlistMultimediale = new ElementoMultimediale[5];

    System.out.println("***** Inserisci gli elementi desiderati *****");

    // Riempio l'array
    for (int i = 0; i < playlistMultimediale.length; i++) {
        System.out.println("Inserisci elemento:" + " " + (i + 1) + " di 5");
        System.out.println("Scegli il tipo di elemento (1 = Audio, 2 = Video, 3 = Immagine): ");

        // Eseguo un controllo su quello che inseriscono tramite hasNextInt
        while (!scanner.hasNextInt()) {
            System.out.println("Errore: inserisci un numero valido!");
            System.out.println("Scegli il tipo di elemento (1 = Audio, 2 = Video, 3 = Immagine): ");
            scanner.nextLine();
        }
        // uso trim così da ripulire gli spazi vuoti all'inizio e alla fine, utilizzato anche per i metodi
        int tipologia = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Inserisci il titolo:");
        String titolo = scanner.nextLine();

        if (titolo.isEmpty()) {
            titolo = scanner.nextLine();
        }

        // Switch per i casi di selezionato
        switch (tipologia) {
            case 1: // AUDIO
                System.out.print("Inserisci la durata:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per la durata!");
                    System.out.print("Inserisci la durata:" + " ");
                    scanner.nextLine();
                }
                int durataAudio = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Inserisci il volume iniziale:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per il volume!");
                    System.out.print("Inserisci il volume iniziale:" + " ");
                    scanner.nextLine();
                }
                int volumeAudio = Integer.parseInt(scanner.nextLine().trim());

                playlistMultimediale[i] = new Audio(titolo, durataAudio, volumeAudio);
                break;

            case 2: // VIDEO
                System.out.print("Inserisci la durata:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per la durata!");
                    System.out.print("Inserisci la durata:" + " ");
                    scanner.nextLine();
                }
                int durataVideo = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Inserisci il volume iniziale:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per il volume!");
                    System.out.print("Inserisci il volume iniziale:" + " ");
                    scanner.nextLine();
                }
                int volumeVideo = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Inserisci la luminosità iniziale:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per la luminosità!");
                    System.out.print("Inserisci la luminosità iniziale:" + " ");
                    scanner.nextLine();
                }
                int luminositaVideo = Integer.parseInt(scanner.nextLine().trim());

                playlistMultimediale[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                break;

            case 3: // IMMAGINE
                System.out.print("Inserisci la luminosità iniziale:" + " ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero per la luminosità!");
                    System.out.print("Inserisci la luminosità iniziale:" + " ");
                    scanner.nextLine();
                }
                int luminositaImmagine = Integer.parseInt(scanner.nextLine().trim());

                playlistMultimediale[i] = new Immagine(titolo, luminositaImmagine);
                break;

            default:
                System.out.println("Errore nel carimento, reinserisci questo elemento");
                i--;
                break;
        }
    }

    // Esecuzione Player Multimediale
    int selezionato = -1;
    while (selezionato != 0) {
        System.out.println("***** PLAYER MULTIMEDIALE *****");
        System.out.println(" Quale elemento multimediale vuoi eseguire da 1 a 5 per scegliere, 0 per chiudere il player:");

        // Elementi disponibili
        for (int i = 0; i < playlistMultimediale.length; i++) {
            System.out.println((i + 1) + "." + playlistMultimediale[i].getTitolo() + "[" + playlistMultimediale[i].getClass().getSimpleName() + "]");
        }
        System.out.println("Scelta:");

        while (!scanner.hasNextInt()) {
            System.out.println("Errore: inserisci un numero da 0 a 5!");
            System.out.println("Scelta:");
            scanner.nextLine();
        }
        selezionato = Integer.parseInt(scanner.nextLine());

        // Recupero dell'elemento seleazionato
        if (selezionato >= 1 && selezionato <= 5) {
            ElementoMultimediale elementoSelezionato = playlistMultimediale[selezionato - 1];
            System.out.println("Esecuzione di:" + " " + elementoSelezionato.getTitolo());

            int opzioni = -1;
            while (opzioni != 0) {
                System.out.println("\nOpzioni eseguibili per :" + elementoSelezionato.getTitolo() + ":");
                System.out.println(" 1 Esegui / Mostra");
                if (elementoSelezionato instanceof Riproducibile) {
                    System.out.println("2. Alza Volume");
                    System.out.println("3. Abbassa Volume");
                    System.out.println("4. Aumenta Luminosità");
                    System.out.println("5. Diminuisci Luminosità");
                }
                if (elementoSelezionato instanceof NonRiproducibile) {
                    System.out.println("2. Aumenta luminosità");
                    System.out.println("3. Diminuisci luminosità");
                }
                System.out.println("0. Torna al menu principale");
                System.out.println("Scelta azione:");

                // eseguo di nuovo il controllo tramite hasNextInt
                while (!scanner.hasNextInt()) {
                    System.out.println("Errore: inserisci un numero valido!");
                    System.out.println("Scelta azione:");
                    scanner.nextLine();
                }

                opzioni = Integer.parseInt(scanner.nextLine().trim());

                switch (opzioni) {
                    case 1 -> {
                        if (elementoSelezionato instanceof Immagine) {
                            ((Immagine) elementoSelezionato).show();
                        } else if (elementoSelezionato instanceof Riproducibile) {
                            ((Riproducibile) elementoSelezionato).play();
                        }
                    }
                    case 2 -> {

                        if (elementoSelezionato instanceof Audio) {
                            ((Audio) elementoSelezionato).alzaVolume(scanner);
                        } else if (elementoSelezionato instanceof Video) {
                            ((Video) elementoSelezionato).alzaVolume(scanner);
                        } else if (elementoSelezionato instanceof Immagine) {
                            ((Immagine) elementoSelezionato).aumentaLuminosita(scanner);
                        } else {
                            System.out.println("Opzione non disponibile per questo elemento multimediale.");
                        }
                    }
                    case 3 -> {
                        if (elementoSelezionato instanceof Audio) {
                            ((Audio) elementoSelezionato).abbassaVolume(scanner);
                        } else if (elementoSelezionato instanceof Video) {
                            ((Video) elementoSelezionato).abbassaVolume(scanner);
                        } else if (elementoSelezionato instanceof Immagine) {
                            ((Immagine) elementoSelezionato).diminuisciLuminosita(scanner);
                        } else {
                            System.out.println("Opzione non disponibile per questo elemento multimediale.");
                        }
                    }
                    case 4 -> {
                        if (elementoSelezionato instanceof Video) {
                            ((Video) elementoSelezionato).aumentaLuminosita(scanner);
                        } else {
                            System.out.println("Opzione non disponibile per questo elemento multimediale.");
                        }
                    }
                    case 5 -> {
                        if (elementoSelezionato instanceof Video) {
                            ((Video) elementoSelezionato).diminuisciLuminosita(scanner);
                        } else {
                            System.out.println("Opzione non disponibile per questo elemento multimediale.");
                        }
                    }
                    case 0 -> System.out.println("Ritorno al menu principale");
                    default -> System.out.println("Scelta non valida, inserisci un numero da 0 a 5.");
                }
            }
        }
    }

    System.out.println("Player chiuso.");
    scanner.close();
}
