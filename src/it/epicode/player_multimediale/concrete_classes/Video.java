package it.epicode.player_multimediale.concrete_classes;

import it.epicode.player_multimediale.abstract_classes.ElementoMultimediale;
import it.epicode.player_multimediale.interfaces.IVideo;
import it.epicode.player_multimediale.interfaces.IAudio;

public class Video extends ElementoMultimediale implements IAudio, IVideo {
    private byte luminosita;
    private byte durata;
    private byte volume;


    public Video(String titolo, byte durata) throws Exception {
        super(titolo);
        this.luminosita = 7;
        this.durata = durata;
        this.volume = 5;
    }


    @Override
    public void aumentaLuminosita(byte param) throws Exception {
        if (param < 1) {
            throw new Exception("Il valore per aumentare la luminosità deve essere positivo.");
        }
        this.luminosita += param;
        System.out.println("Luminosità aumentato di: " + param);
    }

    @Override
    public void diminuiciLuminosita(byte param) throws Exception {
        if (param < 1) {
            throw new Exception("Il valore per diminuire la luminosità deve essere positivo.");
        }
        if (this.luminosita - param < 1) {
            throw new Exception("La luminosità non può scendere sotto 1.");
        }
        this.luminosita -= param;
        System.out.println("Luminosità diminuito di: " + param);
    }

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
        String esclamativo = "";
        String asterisco = "";
        for (int i = 0; i < this.volume; i++) {
            esclamativo+="!";
        }
        for (int i = 0; i < this.luminosita; i++) {
            asterisco+="*";
        }
        for (int i = 0; i < this.durata; i++) {
            System.out.println(this.getTitolo() + esclamativo + asterisco);
        }

    }

    @Override
    public void esegui() {
        play();
    }
}
