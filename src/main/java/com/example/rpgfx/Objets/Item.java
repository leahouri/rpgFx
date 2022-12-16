package com.example.rpgfx.Objets;

public abstract class Item {
    //public=tout le monde  package=dossier  protected=class fille private=class courante , peut modifier
    protected String nom;

    public String getNom() {
        return nom;
    }
}
