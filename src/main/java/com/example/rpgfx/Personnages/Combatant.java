package com.example.rpgfx.Personnages;

import com.example.rpgfx.Objets.Weapon;

import java.util.ArrayList;

public abstract class Combatant {

    protected int lifePoints;
    protected int maxLifePoints;
    protected int mana;
    protected int maxMana;
    protected int force;
    protected float def;
    protected Weapon weapon;

    protected String name;

    protected Team team;

    protected boolean vivant = true;

    public int getLifePoints() {
        return lifePoints;
    }
    public void setLifePoints(int newLifePoints) {

        this.lifePoints = newLifePoints;
    }



    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxLifePoints() {
        return maxLifePoints;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        this.maxLifePoints = maxLifePoints;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public String getName() {return name;}

    public boolean isVivant() {
        return vivant;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public abstract boolean attack(Combatant cible);

    public float getDef() {
        return def;
    }
}
