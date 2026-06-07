package entities;

import interfaces.NonRiproducibile;

public class Immagine extends ElementoMultimediale implements NonRiproducibile {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) luminosita--;
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

