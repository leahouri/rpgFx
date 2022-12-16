package com.example.rpgfx.Personnages;

import java.util.ArrayList;

public class Team {
    private ArrayList<Combatant> teamList;
    private String teamName;

    public Team(String teamName){
        this.teamList  = new ArrayList<Combatant>();
        this.teamName = teamName;
    }

    public void ajoutCombatant(Combatant combatant){
        this.teamList.add(combatant);
    }

    public ArrayList<Combatant> listeVivant(){
        ArrayList<Combatant> liste = new ArrayList<Combatant>();
        for(Combatant c : this.teamList){
            if(c.vivant){
                liste.add(c);
            }
        }
        return liste;

    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Combatant> getTeamList() {
        return teamList;
    }
}
