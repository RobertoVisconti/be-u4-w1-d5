package entities;

import interfaces.Riproducibile;

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

    public void alzaVolume() {
        if (volume < 100) {
            volume++;
            System.out.println("Volume del video alzato. Volume attuale:" + " " + volume);
        } else {
            System.out.println("Il volume del video è già al massimo: 100.");
        }
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume del video abbassato. Volume attuale:" + " " + volume);
        } else {
            System.out.println("Il volume del video è già al minimo: 0");
        }
    }

    public void aumentaLuminosita() {
        if (luminosita < 100) {
            luminosita++;
            System.out.println("Luminosità del video aumentata. Livello attuale:" + " " + luminosita);
        } else {
            System.out.println("Luminosità del video è già al massimo: 100");
        }
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
            System.out.println("Luminosità del video abbassata. Livello attuale:" + " " + luminosita);
        } else {
            System.out.println("La luminosità del video è già al minimo : 0");
        }
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.print(titolo + " ");
            for (int v = 0; v < volume; v++) {
                System.out.println("!");
            }
            for (int l = 0; l < luminosita; l++) {
                System.out.println("*");
            }
            System.out.println();
        }
    }

}
