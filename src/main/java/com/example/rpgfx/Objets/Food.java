package com.example.rpgfx.Objets;

import com.example.rpgfx.Personnages.Hero;

public class Food extends Consumable {

    public Food(String nom, int valeurSoins){
        this.nom = nom;
        this.valeurSoins = valeurSoins;

    }

    @Override
    public void utiliser(Hero hero) {
        hero.setLifePoints(hero.getLifePoints() + this.valeurSoins);
        if (hero.getMaxLifePoints()<hero.getLifePoints()){
            hero.setLifePoints(hero.getMaxLifePoints());
        }

        System.out.println("Le hero " + hero.getName() +" a utilisé la nourriture "+this.nom+" et a restauré "+ this.valeurSoins+
                " de vie");

    }

}
