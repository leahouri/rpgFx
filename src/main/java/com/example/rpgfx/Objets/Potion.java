package com.example.rpgfx.Objets;

import com.example.rpgfx.Objets.Consumable;
import com.example.rpgfx.Personnages.Hero;

public class Potion extends Consumable {
public Potion (String nom, int valeurSoins){

    this.nom = nom;
    this.valeurSoins=valeurSoins;

    }

    @Override
    public void utiliser(Hero hero) {
        hero.setMana(hero.getMana() + this.valeurSoins);
        if (hero.getMaxMana()<hero.getMana()){
            hero.setMana(hero.getMaxMana());
        }
        System.out.println("Le hero " + hero.getName() +" a utilisé la potion "+this.nom+" et a restauré "+ this.valeurSoins+
                " de mana");
    }
}
