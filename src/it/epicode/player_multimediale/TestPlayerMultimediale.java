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
        Immagine img1 = new Immagine("img1");

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
            video1.alzaVolume((byte) 5);
            video1.play();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }
        try {
            video1.diminuiciLuminosita((byte)5);
            video1.abbassaVolume((byte) 7);

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
            video1.abbassaVolume((byte) 10);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        //test immagini

        System.out.println("\n----------------Immagini----------------\n");

        try {
            img1.aumentaLuminosita((byte)3);
            img1.show();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }
        try {
            img1.diminuiciLuminosita((byte)5);
            img1.show();
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        //scateno errori per la classe Immagine
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

        ArrayList<ElementoMultimediale> lettoreMultimediale = new ArrayList<>();

        // Dati del primo file audio
        Audio audio2 = null;
        while (audio2 == null) {
            try {
                System.out.println("Crea il tuo elemento multimediale Audio e aggiungilo alla lista passando i seguenti valori:");
                System.out.println("Inserisci un titolo ATTENZIONE IL TITOLO è UNIVOCO:");
                String titoloAudio1 = sc.nextLine();

                System.out.println("Inserisci durata: un intero da 1 a 127");
                byte durataAudio1 = 1;
                try {
                    durataAudio1 = sc.nextByte();
                    sc.nextLine();
                    if (durataAudio1 < 1 || durataAudio1 > 127) {
                        throw new Exception("La durata deve essere un valore valido tra 1 e 127.");
                    }
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                    sc.nextLine();
                }

                audio2 = new Audio(titoloAudio1, durataAudio1);
                lettoreMultimediale.add(audio2);
            } catch (Exception e) {
                System.out.println("Errore nella creazione dell'Audio: " + e.getMessage());
            }
        }

        // Dati del primo file video
        Video video2 = null;
        while (video2 == null) {
            try {
                System.out.println("Crea il tuo elemento multimediale Video e aggiungilo alla lista passando i seguenti valori:");
                System.out.println("Inserisci un titolo: ATTENZIONE IL TITOLO è UNIVOCO:");
                String titoloVideo1 = sc.nextLine();

                System.out.println("Inserisci durata: un intero da 1 a 127");
                byte durataVideo1 = 1;
                try {
                    durataVideo1 = sc.nextByte();
                    sc.nextLine();
                    if (durataVideo1 < 1 || durataVideo1 > 127) {
                        throw new Exception("La durata deve essere un valore valido tra 1 e 127.");
                    }
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                    sc.nextLine();
                }

                video2 = new Video(titoloVideo1, durataVideo1);
                lettoreMultimediale.add(video2);
            } catch (Exception e) {
                System.out.println("Errore nella creazione del Video: " + e.getMessage());
            }
        }

        // Dati del primo file immagine
        Immagine immagine2 = null;
        while (immagine2 == null) {
            try {
                System.out.println("Crea il tuo elemento multimediale Immagine e aggiungilo alla lista passando i seguenti valori:");
                System.out.println("Inserisci un titolo: ATTENZIONE IL TITOLO è UNIVOCO:");
                String titoloImg1 = sc.nextLine();

                immagine2 = new Immagine(titoloImg1);
                lettoreMultimediale.add(immagine2);
            } catch (Exception e) {
                System.out.println("Errore nella creazione dell'Immagine: " + e.getMessage());
            }
        }

        // Dati del secondo file immagine
        Immagine immagine3 = null;
        while (immagine3 == null) {
            try {
                System.out.println("Crea un altro file Immagine e aggiungilo alla lista passando i seguenti valori:");
                System.out.println("Inserisci un titolo: ATTENZIONE IL TITOLO è UNIVOCO:");
                String titoloImg2 = sc.nextLine();

                immagine3 = new Immagine(titoloImg2);
                lettoreMultimediale.add(immagine3);
            } catch (Exception e) {
                System.out.println("Errore nella creazione dell'Immagine: " + e.getMessage());
            }
        }

        // Dati del secondo file video
        Video video3 = null;
        while (video3 == null) {
            try {
                System.out.println("Crea il tuo secondo elemento multimediale Video e aggiungilo alla lista passando i seguenti valori:");
                System.out.println("Inserisci un titolo: ATTENZIONE IL TITOLO è UNIVOCO:");
                String titoloVideo2 = sc.nextLine();

                System.out.println("Inserisci durata: un intero da 1 a 127");
                byte durataVideo2 = 1;
                try {
                    durataVideo2 = sc.nextByte();
                    sc.nextLine();
                    if (durataVideo2 < 1 || durataVideo2 > 127) {
                        throw new Exception("La durata deve essere un valore valido tra 1 e 127.");
                    }
                } catch (Exception e) {
                    System.out.println("Errore: " + e.getMessage());
                    sc.nextLine();
                }

                video3 = new Video(titoloVideo2, durataVideo2);
                lettoreMultimediale.add(video3);
            } catch (Exception e) {
                System.out.println("Errore nella creazione del Video: " + e.getMessage());
            }
        }

        // Lettore multimediale
        while (true) {
            byte data = -1;
            while (data < 0 || data > 5) {
                System.out.println("Inserisci un valore compreso tra 1 e 5 per decidere che file riprodurre o 0 per terminare:");
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
                System.out.println("Lettore multimediale terminato");
                break;
            } else {
                lettoreMultimediale.get(data - 1).esegui();
            }
        }

    }
}
