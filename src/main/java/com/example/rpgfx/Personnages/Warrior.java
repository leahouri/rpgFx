package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Food;
import com.example.rpgfx.Objets.Potion;
import com.example.rpgfx.Objets.Weapon;

public class Warrior extends Hero{
    public Warrior(String name, int lifePoints, Team team){
        this.name = name;
        this.lifePoints = lifePoints;
        this.maxLifePoints = 1000;
        this.maxMana = 1000;
        this.def = 0.5f;
        this.force = 10;
        this.team = team;
        this.team.ajoutCombatant(this);
        this.heroType = HeroType.WARRIOR;
        this.weapon = new Weapon("Epee",10);
        this.level = 1;
        this.addConsumable(new Food("burger",50));
        this.addConsumable(new Potion("Vodka pomme",50));

    }


    @Override
    public boolean attack(Combatant cible) {
        int damage = (int)(this.weapon.getCapacity()*this.force*cible.getDef());
        cible.setLifePoints(cible.getLifePoints()-damage);
        if(cible.getLifePoints()<=0){
            cible.setVivant(false);
        }
        return true;
    }

}
