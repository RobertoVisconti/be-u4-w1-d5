package entities;

import interfaces.Riproducibile;

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

    public void alzaVolume() {
        if (volume < 100) {
            volume++;
            System.out.println("Volume dell'audio alzato. Volume attuale:" + " " + volume);
        } else {
            System.out.println("Il volume dell'audio è già al massimo: 100.");
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume dell'audio abbassato. Volume attuale:" + " " + volume);
        } else {
            System.out.println("Il volume è già al minimo: 0");
        }
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
