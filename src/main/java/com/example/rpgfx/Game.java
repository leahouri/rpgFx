package com.example.rpgfx;

import com.example.rpgfx.Personnages.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private InputParser inputParser;
    private Team teamHero;
    private Team teamEnemy;
    private int totalHero;
    private ArrayList<Combatant> ordreTour = new ArrayList<Combatant>();
    private Combatant combattantActuel;
    private int level = 1;

    public Game(){

        this.teamEnemy = new Team("Equipe Monstre");


    }

    public void setInputParser(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void start(){
        this.inputParser.nomTeam();
        //this.teamHero = new Team(teamNom);

        //this.inputParser.nombreDeHeros();






    }
    public void createTeam(String nomTeam){
        this.teamHero = new Team(nomTeam);
        this.inputParser.bienvenu();
    }



    public  void boucleHero(int actuel){
        if(actuel<=this.totalHero){
            this.inputParser.demandeHero(actuel);
        }else {
            this.inputParser.afficheTeam(teamHero);
        }
    }

    public void creerHero(int nombre, String nom){
        if(nombre ==1){
            //alors warrior
            new Warrior(nom,700, this.teamHero);
        }else if(nombre == 2){
            //alors Hunter
            new Hunter(nom, 700, this.teamHero);
        }else if(nombre == 3){
            //alors mage
            new Mage(nom,700,this.teamHero);

        }else if(nombre == 4){
            //alors healer
            new Healer(nom, 700, this.teamHero);
        }
        this.boucleHero(this.teamHero.getTeamList().size()+1);

    }

    public void setTotalHero(int totalHero) {
        this.totalHero = totalHero;
    }

    public int getTotalHero() {
        return totalHero;
    }

    public void creerEnemy(int nombreHero){
        String[] listNom = {"Monstre","Fantome","Léa","Antoine Faust","Boss"};
        if(this.level!=5){
            for(int i = 0; i< nombreHero; i = i+1) {
                new Enemy(listNom[this.level - 1], 900, this.teamEnemy);
            }
        }else {
            new Enemy(listNom[this.level-1],1200*this.totalHero,this.teamEnemy);
        }

        this.inputParser.afficheTeam(this.teamEnemy);

    }

    public void ordre(){
        for(int i = 0; i<this.totalHero;i=i+1){
            this.ordreTour.add(this.teamHero.getTeamList().get(i));
            this.ordreTour.add(this.teamEnemy.getTeamList().get(i));
        }
        this.nextCombattant();
        this.inputParser.annonceTour();
    }

    public Combatant getCombattantActuel() {
        return combattantActuel;
    }

    public Team getTeamEnemy() {
        return teamEnemy;
    }

    public Team getTeamHero() {
        return teamHero;
    }

    public void executeAttack(Combatant cible){
        if(!this.combattantActuel.attack(cible)){
            this.inputParser.failMessage();
        }
        this.inputParser.afficheDegats(cible);
    }

    public void finTour(){
        if(this.getTeamHero().listeVivant().size()==0){
            this.lose();
        }else if(this.getTeamEnemy().listeVivant().size()==0){
            if(this.level<5){
                this.levelup();

            }else {
                this.win();
            }
        }else {
            this.nextCombattant();
            this.inputParser.choixAction();
        }
    }


    public void nextCombattant(){
        int i = this.ordreTour.indexOf(this.combattantActuel);
        if(i+1==this.ordreTour.size()){
            i = 0;
        }else {
            i = i+1;
        }
        this.combattantActuel = this.ordreTour.get(i);
    }

    public void lose(){
        this.inputParser.afficheLose();
    }

    public void win(){
        this.inputParser.afficheWin();
    }

    public void useObject(int input){
        Hero h = (Hero)this.combattantActuel;
        h.useConsumable(h.getConsumables().get(input-1));
        this.finTour();

    }

    public void levelup(){
        this.level++;
        for(Combatant c : this.getTeamHero().listeVivant()){
            c.setLifePoints(c.getMaxLifePoints());
            c.setMaxLifePoints(c.getMaxMana());
        }
        this.teamEnemy = new Team("Team de mechant");
        this.ordreTour = new ArrayList<Combatant>();
        this.inputParser.afficheFinCombat();



    }

    public int getLevel() {
        return level;
    }
}

