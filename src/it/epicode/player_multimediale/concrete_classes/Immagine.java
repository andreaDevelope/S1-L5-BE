package it.epicode.player_multimediale.concrete_classes;

import it.epicode.player_multimediale.abstract_classes.ElementoMultimediale;
import it.epicode.player_multimediale.interfaces.IVideo;

public class Immagine extends ElementoMultimediale implements IVideo {
    private byte luminosita;

    public Immagine(String titolo) throws Exception {
        super(titolo);
        this.luminosita = 5;
    }

    @Override
    public void esegui() {
        show();
    }

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

    public void show(){
        String asterisco = "";
        for (int i = 0; i < this.luminosita; i++) {
            asterisco+="*";
        }
        System.out.println(this.getTitolo() + asterisco);
    }
}
