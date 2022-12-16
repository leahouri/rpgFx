package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Food;
import com.example.rpgfx.Objets.Potion;
import com.example.rpgfx.Objets.Weapon;

public class Healer extends SpellCaster {
    public Healer(String name, int lifePoints, Team team){
        this.name = name;
        this.lifePoints = lifePoints;
        this.maxLifePoints = 1000;
        this.maxMana = 1000;
        this.def = 0.5f;
        this.force = 10;
        this.team = team;
        this.team.ajoutCombatant(this);
        this.heroType = HeroType.HEALER;
        this.manaCost = 90;
        this.weapon = new Weapon("Baguette",8);
        this.failMessage = "Vous n'avez plus de mana, votre attaque à échouée";
        this.addConsumable(new Food("burger",50));
        this.addConsumable(new Potion("Vodka pomme",50));

    }

    @Override
    public boolean attack(Combatant cible) {
        int soin = this.force*this.weapon.getCapacity();
        if(this.getMana()>= this.manaCost){
            cible.setLifePoints(cible.getLifePoints()+soin);
            if(cible.getLifePoints()>this.getMaxLifePoints()){
                cible.setLifePoints(cible.getMaxLifePoints());
            }
            this.setMana(this.getMana()-this.manaCost);
            return true;
        }else {
            return false;

        }
    }
}
