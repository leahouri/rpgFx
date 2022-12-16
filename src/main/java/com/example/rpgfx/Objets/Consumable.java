package com.example.rpgfx.Objets;

import com.example.rpgfx.Personnages.Hero;

public abstract class Consumable extends Item {
    protected int valeurSoins;

    public abstract void utiliser(Hero hero);
}
