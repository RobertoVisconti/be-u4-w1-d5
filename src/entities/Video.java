package entities;

import interfaces.Riproducibile;

import java.util.Scanner;

public class Video extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        // Imposto il valore d'inserimento a 100 se inseriscono più di 100, e a 0 se inseriscono un numero negativo
        this.volume = volume > 100 ? 100 : (Math.max(volume, 0));
        this.luminosita = luminosita > 100 ? 100 : (Math.max(luminosita, 0));
    }

    // Aumento e Diminuisco tramite lo scanner
    public void alzaVolume(Scanner scanner) {
        System.out.println("Di quanto vuoi aumentare il volume ?");
        while (!scanner.hasNextInt()) {
            System.out.println("Errore, inserisci un numero valido.");
            scanner.nextLine();
        }
        int valore = Integer.parseInt(scanner.nextLine().trim());
        if (volume + valore <= 100) {
            volume += valore;
        } else {
            volume = 100;
            System.out.println("Il volume dell'audio ha raggiunto il massimo: 100.");
        }
        System.out.print("Volume attuale: ");
        for (int v = 0; v < volume; v++) {
            System.out.print("!");
        }
        System.out.println();
    }

    public void abbassaVolume(Scanner scanner) {
        System.out.println("Di quanto vuoi abbassare il volume ?");
        while (!scanner.hasNextInt()) {
            System.out.println("Errore, inserisci un numero valido.");
        }
        int valore = Integer.parseInt(scanner.nextLine().trim());
        if (volume - valore >= 0) {
            volume -= valore;
        } else {
            volume = 0;
            System.out.println("Il volume è già al minimo: 0");
        }
        System.out.print("Volume attuale: ");
        for (int v = 0; v < volume; v++) {
            System.out.print("!");
        }
        System.out.println();
    }

    public void aumentaLuminosita(Scanner scanner) {
        System.out.println("Di quanto vuoi aumentare la luminosità ?");
        while (!scanner.hasNextInt()) {
            System.out.println("Errore, inserisci un numero valido.");
        }
        int valore = Integer.parseInt(scanner.nextLine().trim());
        if (luminosita + valore <= 100) {
            luminosita += valore;
        } else {
            luminosita = 100;
            System.out.println("Luminosità del video è già al massimo: 100");
        }
        System.out.print("Volume attuale: ");
        for (int l = 0; l < luminosita; l++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void diminuisciLuminosita(Scanner scanner) {
        System.out.println("Di quanto vuoi abbassare la luminosità ?");
        while (!scanner.hasNextInt()) {
            System.out.println("Errore, inserisci un numero valido.");
        }
        int valore = Integer.parseInt(scanner.nextLine().trim());
        if (luminosita - valore >= 0) {
            luminosita -= valore;
        } else {
            luminosita = 0;
            System.out.println("La luminotà del video  è già al minimo : 0");
        }
        System.out.print("Volume attuale: ");
        for (int l = 0; l < luminosita; l++) {
            System.out.print("*");
        }
        System.out.println();
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.print(titolo + " ");
            for (int v = 0; v < volume; v++) {
                System.out.print("!");
            }
            for (int l = 0; l < luminosita; l++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
