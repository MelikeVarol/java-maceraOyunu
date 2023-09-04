package org.example;

import java.util.Scanner;

public abstract class Location {
    private Player player; // Location içine oyuncumuzu atmamız lazım bu yüzden player adında bir nesne ürettim.
    private String name;
    public static Scanner input=new Scanner(System.in);//Alt sınıfarda erişilebilir.
    //static taaımlamamın sebebi bir kere taımlansın her locationdan veya alt sınıflarında  nesne ürettiğimde tekrar üretilsin istemedim hafızadan tasarruf ettim.

    public Location(Player player,String name)
    {
        this.player=player;
        this.name=name;
    }

    public abstract boolean onLocation();//Tüm lokasyonlar(alt sınıfları) bu metotdu kullanmasını istiyorum bu yüzden abstract tanımladım.
    //Abstract metotlar, bir sınıfın alt sınıfları tarafından implemente edilmek (gerçekleştirilmek) zorunda olan metotlardır.

    public Player getPlayer()
    {
        return player;
    }
    public void setPlayer(Player player)
    {
        this.player=player;
    }
    public String getName()
    {
        return name;
    }
    public void setName()
    {
        this.name=name;
    }

}
