package it.epicode.player_multimediale.abstract_classes;

import java.util.ArrayList;

public abstract class ElementoMultimediale {
    private static ArrayList<String> titoliUsati = new ArrayList<>();
    private String titolo;

    public ElementoMultimediale(String titolo) throws Exception {
        if (titoliUsati.contains(titolo)) {
            throw new Exception("Il titolo '" + titolo + "' è già stato utilizzato. I titoli devono essere univoci.");
        }
        this.titolo = titolo;
        titoliUsati.add(titolo);
    }

    public String getTitolo() {
        return this.titolo;
    }

    public abstract void esegui();
}
