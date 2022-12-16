package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Food;
import com.example.rpgfx.Objets.Potion;
import com.example.rpgfx.Objets.Weapon;

public class Hunter extends Hero {
    private int fleches;
    public Hunter(String name, int lifePoints, Team team){
        this.name = name;
        this.lifePoints = lifePoints;
        this.maxLifePoints = 1000;
        this.maxMana = 1000;
        this.def = 0.5f;
        this.force = 10;
        this.team = team;
        this.team.ajoutCombatant(this);
        this.heroType = HeroType.HUNTER;
        this.fleches = 10;
        this.weapon = new Weapon("Arc",8);
        this.failMessage = "Vous n'avez plus de flèches";
        this.addConsumable(new Food("burger",50));
        this.addConsumable(new Potion("Vodka pomme",50));
    }

    @Override
    public boolean attack(Combatant cible) {
        int damage = this.force*this.weapon.getCapacity() +10;
        if(this.fleches>0){
            cible.setLifePoints(cible.getLifePoints()- damage);
            if (cible.getLifePoints()<=0){
                cible.setVivant(false);
            }
            this.fleches--;
            return true;
        }else {
            return false;

        }


    }
}
