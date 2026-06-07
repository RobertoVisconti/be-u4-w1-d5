package entities;

import interfaces.NonRiproducibile;

public class Immagine extends ElementoMultimediale implements NonRiproducibile {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        // Imposto il valore d'inserimento a 100 se inseriscono più di 100, e a 0 se inseriscono un numero negativo
        if (luminosita > 100) this.luminosita = 100;
        else if (luminosita < 0) this.luminosita = 0;
        else this.luminosita = luminosita;
    }

    public void aumentaLuminosita() {
        if (luminosita < 100) {
            luminosita++;
            System.out.println("Luminosità dell'immagine aumentata. Livello attuale:" + " " + luminosita);
        } else {
            System.out.println("Luminosità dell'immagine è già al massimo: 100");
        }
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
            System.out.println("Luminosità dell'immagine abbassata. Livello attuale:" + " " + luminosita);
        } else {
            System.out.println("La luminotà dell'immagine  è già al minimo : 0");
        }
    }

    @Override
    public void show() {
        System.out.print(titolo + " ");
        for (int i = 0; i < luminosita; i++) {
            System.out.println("*");
        }
        System.out.println();
    }
}

