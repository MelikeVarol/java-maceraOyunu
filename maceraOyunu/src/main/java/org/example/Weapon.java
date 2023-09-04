package org.example;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon (String name,int id,int damage,int price)
    {
        this.name=name;
        this.id=id;
        this.damage=damage;
        this.price=price;
    }

    public static Weapon[] weapons ()
    {
        Weapon[] weaponList =new Weapon[3];
        weaponList[0]=new Weapon("- Tabanca",1,3,15);
        weaponList[1]=new Weapon("- Kılıç",2,5,35);
        weaponList[2]=new Weapon("- Tüfek",3,7,45);
        return weaponList;

    }
    public  static  Weapon getWeaponObjByID(int id)//İd ye göre obje getir.
    {

        for (Weapon w:Weapon.weapons())
        {
            if (w.getId()==id)
            {
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }
    public void setId()
    {
        this.id=id;
    }

    public int getDamage()
    {
        return damage;
    }
    public void setDamage()
    {
        this.damage=damage;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice()
    {
        this.price= price;
    }
}
