package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Consumable;
import com.example.rpgfx.Personnages.Combatant;

import java.util.ArrayList;

public abstract class Hero extends Combatant {


    protected String failMessage;
    protected int level;
    protected HeroType heroType;
    protected ArrayList<Consumable> consumables = new ArrayList<Consumable>();



    public HeroType getHeroType() {
        return heroType;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void addConsumable(Consumable c){
        this.consumables.add(c);
    }

    public void useConsumable(Consumable c){
        c.utiliser(this);
        this.consumables.remove(c);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }
}


