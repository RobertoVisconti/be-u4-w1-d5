package entities;

import interfaces.NonRiproducibile;

import java.util.Scanner;

public class Immagine extends ElementoMultimediale implements NonRiproducibile {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        // Imposto il valore d'inserimento a 100 se inseriscono più di 100, e a 0 se inseriscono un numero negativo
        if (luminosita > 100) this.luminosita = 100;
        else if (luminosita < 0) this.luminosita = 0;
        else this.luminosita = luminosita;
    }

    // Aumento e Diminuisco tramite lo scanner
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
    public void show() {
        System.out.print(titolo + " ");
        for (int l = 0; l < luminosita; l++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

