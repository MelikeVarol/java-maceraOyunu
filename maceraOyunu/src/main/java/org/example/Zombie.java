package org.example;

public class Zombie extends Obstacle{
    //Constructor.
    public Zombie() //int id, int damage, int health parametre olarak yazmadım ben direk yazdım değerleri.
    {
        super(1,"Zombie",3,10,4); //zombiyi öldürünce 4 para ödül kazanırısn.
    }
}
