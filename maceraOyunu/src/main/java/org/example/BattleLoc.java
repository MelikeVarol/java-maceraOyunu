package org.example;

import java.util.Random;

public  abstract class BattleLoc extends Location
{
    private Obstacle obstacle;//BattleLoc içinde kendine ait obsatcle oluştrdum.
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name,Obstacle obstacle,String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber =this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("DİKKATLİ OL!!! BURADA " + obsNumber + " tane "+ this.getObstacle().getName() + " yaşıyor 👹👹👹");
        System.out.print("<S>avaş veya <K>aç ---> ");
        String selectCase =input.nextLine();//Locationda Scanner tanımladığım için burda direkt input alınabilir tekrar Scanner tanımlamaya gerek yok.
        selectCase=selectCase.toUpperCase();//Küçük harf girerse büyütüyor.
        if (selectCase.equals("S") && combat(obsNumber))// combat return false dönerse bu işlem gerçekleşmiyor
        {
            System.out.println("Savaşma işlemleri yapılacak");
            System.out.println(this.getName() + " tüm düşmanları yendiniz 💪💪");
            return true;


        }
        if (this.getPlayer().getHealth() <= 0)//Öldün:(
        {
            System.out.println("ÖLDÜNÜZ");
            return false;
        }

        return true;
    }
    public boolean combat(int obsNumber) //obsNumber=canavar sayısı
    {

        //Kaç canavar varsa o kadar savaşmamı sağlicak.
        for (int i=1;i<=obsNumber;i++)
        {
            this.getObstacle().setHealth(this.obstacle.getOrjinalHealth());//Amacım 2.canavarın canı hiçbir zaman önceki canavar değeri olmicak bu yüzden 2. canavar canını orjinal can ile değiştiriyorum.
            playerStats();
            obstacleStates(i);
            // Ben düşmana vurcam düşman bana vurucak ve bu olay kaçıncıda biticeğini bilmediğim için while yapıyorum.
            while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0)// benim ve canavarın canı 0 dan büyük olduğu sürece
            {
                System.out.print("<V>ur veya <K>aç --> ");
                String selectCombat= input.nextLine().toUpperCase();//Gİrdiğim değerin uppercaseni al.
                if (selectCombat.equals("V"))
                {
                    System.out.println("Siz Vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());//canavarın canından benim verdiğim hasarı çıkarttım.
                    afterHit();
                    if(this.getObstacle().getHealth()>0)
                    {
                        System.out.println();
                        System.out.println("!!! CANAVAR SİZE VURDU !!!");
                        int obstaclaDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstaclaDamage<0)
                        {
                            obstaclaDamage =0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-obstaclaDamage);//kendi canımın değeri değişti.
                        afterHit();
                    }

                }
                else //kaçmayı seçersem false döndürcem
                {
                    return false;
                }
            }
            if(this.getObstacle().getHealth()<this.getPlayer().getHealth())//obstacle canı benim canımdan küçük ise ben yemiş olurum:)
            {
                System.out.println("DÜŞMANI YENDİNİZZZ");
                System.out.println(this.getObstacle().getAward() + " PARA KAZANDINIZ 💰💰💰");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                System.out.println("GÜNCEL PARANIZ ---> "+this.getPlayer().getMoney());
            }
            else
            {
                return false;
            }
        }
        return  true;
    }
    public void afterHit()
    {
        System.out.println("Canınız : "+ this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " CANI: " + this.getObstacle().getHealth());
        System.out.println();
    }


    public void playerStats()
    {
        System.out.println("-----------------------");
        System.out.println("OYUNCU DEĞERLERİ");
        System.out.println("-----------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStates(int i)
    {
        System.out.println("-----------------------");
        System.out.println(i + "." + this.getObstacle().getName() + " DEĞERLERİ");
        System.out.println("-----------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
        System.out.println();


    }
    public int randomObstacleNumber()
    {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) +1; //maxObstacle kısmının yerine  diyelim ki 3 yazdık --> 1,2,3 arasındna random gelicek
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
