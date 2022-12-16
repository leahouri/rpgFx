package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Weapon;
import com.example.rpgfx.Personnages.Combatant;

public class Enemy extends Combatant {

    public Enemy(String name, int lifePoints, Team team){
        this.name = name;
        this.lifePoints = lifePoints;
        this.maxLifePoints = 900;
        this.maxMana = 800;
        this.def = 0.9f;
        this.force = 8;
        this.team = team;
        this.team.ajoutCombatant(this);
        this.weapon = new Weapon("Faux",8);


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

