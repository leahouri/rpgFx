package com.example.rpgfx;

import com.example.rpgfx.Objets.Consumable;
import com.example.rpgfx.Objets.Food;
import com.example.rpgfx.Personnages.*;
import com.example.rpgfx.Personnages.Team;

import java.util.*;

public class ConsoleParser implements InputParser{
    public Scanner scanner;
    private Game game;

    public ConsoleParser(Game game){
        this.game = game;

        this.scanner = new Scanner(System.in);
    }

    @Override
    public void bienvenu() {
        System.out.println("Bienvenu dans mon jeu de RPG, j'espere que vous allez bien vous amuser !\n");
        this.nombreDeHeros();
    }

    @Override
    public void nombreDeHeros() {
        System.out.println("Choisis le nombre de héros que tu veux!");
        int nombre = demandeNombre(this.scanner);
        while(nombre==0){
            System.out.println("Veuillez entrer un nombre positif");
            nombre = demandeNombre(this.scanner);
        }
        this.game.setTotalHero(nombre);
        this.game.boucleHero(1);
    }


    @Override
    public void demandeHero(int numero) {
        //System.out.println("Vous allez maintenant creer vos heros");

        System.out.println("Veuillez choisir la classe du hero numero "+numero);
        System.out.println("Warrior (1)");
        System.out.println("Hunter  (2)");
        System.out.println("Mage    (3)");
        System.out.println("Healer  (4)");
        int nombre = demandeNombre(this.scanner);
        while(nombre != 1 && nombre !=2 && nombre != 3 && nombre!=4){
            System.out.println("Veuillez entrer le chiffre 1, 2, 3 ou 4");
            nombre = demandeNombre(this.scanner);
        }

        this.nomHero(nombre);

    }

    @Override
    public void nomHero(int nombre) {
        System.out.println("Veuillez entrer le nom de votre hero");
        String nom = this.scanner.nextLine();
        this.game.creerHero(nombre,nom);

    }

    @Override
    public void nomTeam() {
        System.out.println("Veuillez entrer un nom pour votre equipe de hero");
        String nom = this.scanner.nextLine();
        this.game.createTeam(nom);
    }


    @Override
    public void afficheTeam(Team team) {
        System.out.println("\n--------------------------------------------------------\n");

        if(team.getTeamList().size() >0){
            Combatant combatant0 = team.getTeamList().get(0);
            if(combatant0 instanceof Hero){
                System.out.println("Voici vos heros");
                for(Combatant combatant : team.getTeamList()){
                    Hero hero = (Hero)combatant;
                    System.out.println("Classe : "+ hero.getHeroType().toString()+
                            " | Nom : "+ hero.getName()+" | Life points "+hero.getLifePoints());

                }
                this.game.creerEnemy(this.game.getTotalHero());

            }else{

                System.out.println("Voici vos ennemis");
                for(Combatant combatant : team.getTeamList())
                System.out.println("Nom enemy : "+combatant.getName()+" | Life points : "+combatant.getLifePoints());
                this.game.ordre();

            }

        }


    }

    @Override
    public void annonceTour() {
        System.out.println("\nC'est le tour de "+this.game.getCombattantActuel().getName());
        System.out.println("\n"+"-".repeat(30));
        this.choixAction();
    }

    @Override
    public void choixAction(){
        System.out.println("C'est le tour de "+this.game.getCombattantActuel().getName()+"\n");
        if(this.game.getCombattantActuel() instanceof Hero){
            System.out.println("Quelle action veux tu executer ?");
            System.out.println("(1) Attaque");
            System.out.println("(2) Objet");
            int input = demandeNombre(this.scanner);
            while(input!= 1 && input!=2){
                System.out.println("Veuillez entrer 1 ou 2");
                input = demandeNombre(this.scanner);
            }
            if(input==1){
                this.choixCible();
            }else {
                this.choixObjet();
            }

        }else{
            int i = (int)(Math.random()*this.game.getTeamHero().listeVivant().size()-1);
            Combatant cible = this.game.getTeamHero().listeVivant().get(i);
            System.out.println(this.game.getCombattantActuel().getName()+" attaque "+cible.getName());
            this.game.executeAttack(cible);
        }
    }

    @Override
    public void choixCible() {
        System.out.println("-".repeat(30));
        System.out.println("\nVeuillez choir votre cible");
        ArrayList<Combatant> list;
        if(this.game.getCombattantActuel() instanceof Healer){
            list = this.game.getTeamHero().listeVivant();
        }else {
            list = this.game.getTeamEnemy().listeVivant();
        }
        for(Combatant combatant : list){
            int indice = list.indexOf(combatant)+1;
            System.out.println("("+indice+") "+combatant.getName()+" | Life points : "+combatant.getLifePoints());
        }
        int input = demandeNombre(this.scanner);
        while(input<1 || input>list.size()+1){
            System.out.println("Veuillez entrer une entree valide");
            input = demandeNombre(this.scanner);
        }
        Combatant cible = list.get(input-1);
        this.game.executeAttack(cible);

    }

    @Override
    public void choixObjet() {

        Hero h = (Hero) this.game.getCombattantActuel();
        if(h.getConsumables().size()>0){
            System.out.println("Veuillez choisir un objet a consommer : \n");
            for(Consumable c : h.getConsumables()){
                if(c instanceof Food){
                    System.out.println("("+(h.getConsumables().indexOf(c)+1)+") "+ c.getNom());
                }else{
                    System.out.println("("+(h.getConsumables().indexOf(c)+1)+") "+c.getNom());
                }

            }
            int intput = demandeNombre(this.scanner);
            while (intput<1 && intput>h.getConsumables().size()){
                System.out.println("Veuillez entrer une valeur correcte");
                intput = demandeNombre(this.scanner);
            }
            System.out.println("Le combattant a utilise un objet\n");
            this.game.useObject(intput);

        }else{
            System.out.println("Vous n'avez pas d'objets a consommer");
            this.game.finTour();
        }

    }

    @Override
    public void failMessage() {
        Hero h = (Hero)this.game.getCombattantActuel();
        System.out.println(h.getFailMessage());
    }

    @Override
    public void afficheDegats(Combatant cible) {
        System.out.println("Le combattant "+cible.getName()+" a maintenant "+cible.getLifePoints()+" points de vie");
        this.game.finTour();

    }

    @Override
    public void afficheLose() {
        System.out.println("Oh non ! Vous avez perdu la partie !");
    }

    @Override
    public void afficheWin() {
        System.out.println("Felicitation vous avez gagne !");
    }

    @Override
    public void afficheFinCombat() {
        System.out.println("\n"+"-".repeat(30));
        System.out.println("Bravo vous avez fini le niveau "+(this.game.getLevel()-1)+"\n");
        System.out.println("Vous passez maintenant au niveau "+this.game.getLevel());
        this.game.creerEnemy(this.game.getTotalHero());
    }


    public static boolean onlyNumbers(String entree){
        if(entree == ""){
            return false;
        }
        List<Character> chiffre = Arrays.asList('1','2','3','4','5','6','7','8','9','0');
        char[] entreeList = entree.toCharArray();
        for(char c : entreeList){
            if(!chiffre.contains(c)){
                return false;
            }
        }
        return true;
    }

    public static int demandeNombre(Scanner scanner){
        String entree = scanner.nextLine();
        while(!onlyNumbers(entree)){
            System.out.println("Veuillez donner une entree valide");
            entree = scanner.nextLine();
        }
        return Integer.parseInt(entree);

    }


}
