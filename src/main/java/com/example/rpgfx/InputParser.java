package com.example.rpgfx;

import com.example.rpgfx.Personnages.Combatant;
import com.example.rpgfx.Personnages.Team;

public interface InputParser {
    void bienvenu();
    void nombreDeHeros();
    void demandeHero(int nombreHero);
    void nomHero(int numero);
    void nomTeam();
    void afficheTeam(Team team);
    void annonceTour();
    void choixAction();
    void choixCible();
    void choixObjet();
    void failMessage();
    void afficheDegats(Combatant cible);
    void afficheLose();
    void afficheWin();
    void afficheFinCombat();




}
