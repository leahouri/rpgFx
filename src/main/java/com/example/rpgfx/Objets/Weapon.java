package com.example.rpgfx.Objets;

public class Weapon extends Item {

   private int capacity;
   public Weapon(String weaponName, int weaponCapacity){
      this.nom = weaponName;
      this.capacity = weaponCapacity;
   }

   public int getCapacity() {
      return capacity;
   }
}
