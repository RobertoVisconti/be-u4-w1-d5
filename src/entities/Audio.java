package entities;

import interfaces.Riproducibile;

import java.util.Scanner;

public class Audio extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        // Imposto il valore d'inserimento a 100 se inseriscono più di 100, e a 0 se inseriscono un numero negativo
        if (volume > 100) this.volume = 100;
        else if (volume < 0) this.volume = 0;
        else this.volume = volume;
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


    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.print(titolo + " ");
            for (int v = 0; v < volume; v++) {
                System.out.print("!");
            }
            System.out.println();
        }
    }
}
