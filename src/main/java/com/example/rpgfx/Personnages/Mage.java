package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Food;
import com.example.rpgfx.Objets.Potion;
import com.example.rpgfx.Objets.Weapon;

public class Mage extends SpellCaster {
    public Mage(String name, int lifePoints, Team team){
        this.name = name;
        this.lifePoints = lifePoints;
        this.maxLifePoints = 1000;
        this.maxMana = 1000;
        this.def = 0.5f;
        this.force = 10;
        this.team = team;
        this.team.ajoutCombatant(this);
        this.heroType = HeroType.MAGE;
        this.weapon = new Weapon("Baton",8);
        this.manaCost = 100;
        this.failMessage = "Vous n'avez plus de mana, votre attaque à échouée";
        this.addConsumable(new Food("burger",50));
        this.addConsumable(new Potion("Vodka pomme",50));

    }


    @Override
    public boolean attack(Combatant cible) {
        int damage = this.force*this.weapon.getCapacity();
        if(this.getMana()>=this.manaCost){
            cible.setLifePoints(cible.getLifePoints()-damage);
            this.setMana(this.getMana()-this.manaCost);
            if(cible.getLifePoints()<=0){
                cible.setVivant(false);
            }
            return true;
        }else {
            return false;
        }

    }
}
