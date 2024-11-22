package it.epicode.player_multimediale;

import it.epicode.player_multimediale.abstract_classes.ElementoMultimediale;
import it.epicode.player_multimediale.concrete_classes.Audio;
import it.epicode.player_multimediale.concrete_classes.Immagine;
import it.epicode.player_multimediale.concrete_classes.Video;

import java.util.ArrayList;
import java.util.Scanner;

public class TestPlayerMultimediale {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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

        //inizio lettore multimediale

        System.out.println("\n----------------Interazione con l'utente----------------\n");

        //dati del primo file audio
        System.out.println("crea il tuo elemento multimediale Audio e aggiungilo alla lista passando " +
                "i seguenti valori: " +
                "\ninserisci un titolo");
        String titoloAudio1 = sc.nextLine();

        System.out.println("inserisci durata: un intero da 1 a 127");
        byte durataAudio1 = 1;
        try {
            System.out.println("Inserisci la durata del video (byte):");
            durataAudio1 = sc.nextByte();
            sc.nextLine();
            if (durataAudio1 < 1 || durataAudio1 > 127) {
                throw new Exception("La durata deve essere un valore byte valido (tra -128 e 127).");
            }
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }


        //dati del primo file video
        System.out.println("crea il tuo elemento multimediale Video e aggiungilo alla lista passando " +
                "i seguenti valori: " +
                "\ninserisci un titolo");

        String titoloVideo1 = sc.nextLine();

        byte durataVideo1 = 1;
        try {
            System.out.println("inserisci durata: un intero da 1 a 127");

            durataVideo1 = sc.nextByte();
            sc.nextLine();
            if (durataVideo1 < 1 || durataVideo1 > 127) {
                throw new Exception("La durata deve essere un valore byte valido (tra -128 e 127).");
            }
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

        //dati del primio file img

        System.out.println("crea il tuo elemento multimediale Immagine e aggiungilo alla lista passando " +
                "i seguenti valori: " +
                "\ninserisci un titolo");
        String titoloImg1 = sc.nextLine();

        //dati del secondo file img
        System.out.println("crea un altro file Immagine e aggiungilo alla lista passando " +
                "i seguenti valori: " +
                "\ninserisci un titolo");
        String titoloImg2 = sc.nextLine();

        //dati secondo file video
        System.out.println("crea il tuo secondo elemento multimediale Video e aggiungilo alla lista passando " +
                "i seguenti valori: " +
                "\ninserisci un titolo");

        String titoloVideo2 = sc.nextLine();

        byte durataVideo2 = 1;
        try {
            System.out.println("inserisci durata: un intero da 1 a 127");

            durataVideo2 = sc.nextByte();
            sc.nextLine();
            if (durataVideo2 < 1 || durataVideo2> 127) {
                throw new Exception("La durata deve essere un valore byte valido (tra -128 e 127).");
            }
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

        //creo una lista con i 5 file multimediali
        Audio audio2 = new Audio(titoloAudio1, durataAudio1);
        Video video2 = new Video(titoloVideo1, durataVideo1);
        Video video3 = new Video(titoloVideo2, durataVideo2);
        Immagine immagine2 = new Immagine(titoloImg1);
        Immagine immagine3 = new Immagine(titoloImg2);

        ArrayList<ElementoMultimediale> lettoreMultimediale = new ArrayList<>();
        lettoreMultimediale.add(audio2);
        lettoreMultimediale.add(video2);
        lettoreMultimediale.add(immagine2);
        lettoreMultimediale.add(immagine3);
        lettoreMultimediale.add(video3);

        //creo un lettore multimediale con l aiuto dello scanner

        while (true) {
            byte data = -1;
            while (data < 0 || data > 5) {
                System.out.println("inserisci un valore compreso tra 1 e 5 per decidere che file riprodurre" +
                        " o 0 per terminare");
                try {
                    data = sc.nextByte();
                    sc.nextLine();
                    if (data < 0 || data > 5) {
                        System.out.println("Errore: valore consentito tra 1 e 5, oppure 0 per terminare.");
                    }
                } catch (Exception e) {
                    System.out.println("Errore: inserisci un valore numerico valido.");
                    sc.nextLine();
                }
            }

            if (data == 0) {
                System.out.println("lettore multimediale terminato");
                break;
            } else {
                lettoreMultimediale.get(data - 1).esegui();
            }
        }
    }
}
