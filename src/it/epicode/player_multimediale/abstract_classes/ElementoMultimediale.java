package it.epicode.player_multimediale.abstract_classes;

public abstract class ElementoMultimediale {
    private String titolo;

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo(){
        return this.titolo;
    }
}


