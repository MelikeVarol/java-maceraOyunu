package org.example;

public class Cave extends BattleLoc {
    //Constructor
    public Cave(Player player)//diğer parametreleri sildim kendim giricem aşağıda:)
     {
        super(player, "Mağara", new Zombie(),"food" , 3);
        // yani mağarada max 3 ayı çıkabilir
    }
}
