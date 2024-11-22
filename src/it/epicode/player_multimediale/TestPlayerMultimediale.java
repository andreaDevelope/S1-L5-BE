package it.epicode.player_multimediale;

import it.epicode.player_multimediale.concrete_classes.Audio;
import it.epicode.player_multimediale.concrete_classes.Video;

public class TestPlayerMultimediale {
    public static void main(String[] args) {
        Audio audio1 = new Audio("audio1", (byte) 5);
        Video video1 = new Video("video1", (byte) 5);

        System.out.println("----------------Audio----------------\n");

        //esempio di chiamate a buon fine
        try {
            audio1.alzaVolume((byte) 2);
            audio1.play();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        try {
            audio1.abbassaVolume((byte) 5);
            audio1.play();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        // scateno gli erorri con valori non validi
        try {
            audio1.alzaVolume((byte) -3);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        try {
            audio1.abbassaVolume((byte) 10);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        System.out.println("\n----------------Video----------------\n");

        //test Video
        try {
            video1.aumentaLuminosita((byte)3);
            video1.play();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }
        try {
            video1.diminuiciLuminosita((byte)5);
            video1.play();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        //scateno errori per la classe Video
        try {
            video1.aumentaLuminosita((byte) -3);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        try {
            video1.diminuiciLuminosita((byte) 10);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

    }
}
