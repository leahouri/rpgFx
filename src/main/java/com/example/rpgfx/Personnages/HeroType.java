package com.example.rpgfx.Personnages;

public enum HeroType {
    WARRIOR,
    HEALER,
    MAGE,
    HUNTER;

    public String toString(){
        if(this.equals(HeroType.WARRIOR)){
            return "Warrior";
        }else if(this.equals(HeroType.HEALER)){
            return "Healer";
        }else if(this.equals(HeroType.MAGE)){
            return "Mage";
        }else{
            return "Hunter";
        }
    }

}
