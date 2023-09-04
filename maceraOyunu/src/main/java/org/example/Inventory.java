package org.example;

public class Inventory {
  private Weapon weapon;
  private Armor armor;
  public Inventory()
  {
      //VARSAYILAN
      this.weapon=new Weapon("Yumruk",-1,0,0);//Inventory içine Weapon adında nesne atadım.
      this.armor=new Armor(-1,"Paçavra",0,0);
  }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
