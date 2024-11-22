package it.epicode.player_multimediale.concrete_classes;

import it.epicode.player_multimediale.abstract_classes.ElementoMultimediale;
import it.epicode.player_multimediale.interfaces.IAudio;

public class Audio extends ElementoMultimediale implements IAudio {
    private byte durata;
    private byte volume;

    public Audio(String titolo, byte durata) {
        super(titolo);
        this.durata = durata;
        this.volume = 5;
    }

    @Override
    public void alzaVolume(byte param) throws Exception {
        if (param < 1) {
            throw new Exception("Il valore per aumentare il volume deve essere positivo.");
        }
        this.volume += param;
        System.out.println("Volume aumentato di: " + param);
    }

    @Override
    public void abbassaVolume(byte param) throws Exception {
        if (param < 1) {
            throw new Exception("Il valore per diminuire il volume deve essere positivo.");
        }
        if (this.volume - param < 1) {
            throw new Exception("Il volume non può scendere sotto 1.");
        }
        this.volume -= param;
        System.out.println("Volume diminuito di: " + param);
    }

    public void play() {
        String asterisco = "";
        for (int i = 0; i < this.volume; i++) {
            asterisco+="!";
        }
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.getTitolo() + asterisco);
        }

    }
}
