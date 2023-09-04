package org.example;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String name;
    private String charName;//aldığı karakter ismi için
    private Scanner input =new Scanner(System.in);
    private  Inventory inventory;


    //Constructor yazarken tek name değişkenini yazdım çünkü oyuncu ismini dışarıdan alıcam
    //diğer değerleri oyunda kullanıcıya seçtiricem.
     public Player (String name)
    {
        this.name=name;
        this.inventory=new Inventory();
    }

    public void selectChar()
    {
        //karakterşlerimi nesne gibi davrandırabiliyorum.Ama aşağıda array oluşturudm bunları da yoruma aldım
        //Samurai samurai =new Samurai();
        //Knight knight =new Knight();
        //Archer archer =new Archer();

        GameCharacter[] charList={new Samurai(),new Archer(),new Knight()};// samurai üst sınıfı GameCharacter olduğu için polimorfizm kullanabildim.
        System.out.println("------KARAKTERLER------");
        /*
        //FOR EACH YAPISI
         int[] numbers = {1, 2, 3, 4, 5};
         for (int num : numbers){
             System.out.println(num);}
         */
        for(GameCharacter gameCharacter :charList)
        {
            System.out.println("ID: "+ gameCharacter.getId()+
                    "\t Karakter ---> " + gameCharacter.getName() +
                    "\t Hasar: "+gameCharacter.getDamage() +
                    "\t Sağlık: " + gameCharacter.getHealth() +
                    "\t Para: " + gameCharacter.getMoney() );
        }

        /*
        //bunu yukarda for eachh ile kısalttım.
        System.out.println("Karekter -----> Samuray\t Hasar: 5\tSağlık:21\tPara:15");
        System.out.println("Karekter -----> Okçu\t Hasar: 7\tSağlık:18\tPara:20");
        System.out.println("Karekter -----> Şovalye\t Hasar: 8\tSağlık:24\tPara:5");
        */
        System.out.println("##############################################################");
        System.out.print("LÜTFEN BİR KARAKTER SEÇİNİZ...");
        int selectChar=input.nextInt();
        switch (selectChar)
        {
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;

            default:
                initPlayer(new Samurai());// eğer kullancı 1,2,3 seçmezse default olarak samuray atancak:)
                break;
        }
        System.out.println("İŞTE SEÇTİĞİN KARAKTER " + this.getCharName() +
                "--> Hasar: "+this.getDamage() +
                ", Sağlık: " + this.getHealth()+
                ", Para: "+this.getMoney());
    }


    public  void initPlayer(GameCharacter gameCharacter)
    {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney((gameCharacter.getMoney()));
        this.setCharName(gameCharacter.getName());
        this.setOrjinalHealth(gameCharacter.getHealth());//setOrjinalHealthi seçtiğim karakter health i ile değiştirdim.
    }

    public void printInfo()
    {
        System.out.println( "Silahınız: "+this.getInventory().getWeapon().getName()+
                ", Zırhınız: "+this.getInventory().getArmor().getName()+
                ", Bloklama: "+this.getInventory().getArmor().getBlock()+
                "--> Hasarınız : "+this.getTotalDamage() +
                ", Sağlığınız : " + this.getHealth()+
                ", Paranız : "+this.getMoney());
    }

    public int getTotalDamage()
    {
        return damage + this.getInventory().getWeapon().getDamage();

    }
    public int getDamage()
    {
        return damage;
    }
    public void setDamage( int damage)
    {
        this.damage=damage;
    }
    public int getHealth()
    {
        return health;
    }
    public void setHealth(int health)
    {
        this.health = health;
    }
    public int getMoney()
    {
        return money;
    }
    public  void setMoney(int money)
    {
        this.money=money;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getCharName()
    {
        return charName;
    }
    public void setCharName(String charName)
    {
        this.charName=charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}