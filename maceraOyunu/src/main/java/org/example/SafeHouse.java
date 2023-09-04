package org.example;

public class SafeHouse extends NormalLoc {


    //Constructor
    public SafeHouse(Player player)//,String name yazmadım çünkü kendim yazdım kullanıcıdan almama gerek yoktu.

    {
        super(player,"GÜVENLİ EV");
    }

    @Override
    public boolean onLocation()
    {
        System.out.println("🏠 Güvenli Evdesiniz 🏠");
        System.out.println("💪💪🩸🩸Canınız Yenilendi💪💪🩸🩸");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());//Her SafeHouse geldiğimde canım yükselicek orjinal canım olcak.
        return true;
    }


}
