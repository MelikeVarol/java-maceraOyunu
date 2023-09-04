package org.example;

import java.util.Scanner;

public class Game {
    private Scanner input=new Scanner(System.in);
    public void start()
    {
        System.out.println("MACERA OYUNUNA HOŞGELDİNİZ \n");
        System.out.print("Lütfen Bir İsim Giriniz : ");
        String playerName= input.nextLine();
        Player player =new Player(playerName);//playerName i construcyora attım.
        System.out.println("OYUNCU " + player.getName() + " ADAYA HOŞGELDİNN 😃🐱‍👤👾");
        System.out.println("##############################################################");
        player.selectChar();


        Location location =null;
        while (true)
        {
            player.printInfo();
            System.out.println();
            System.out.println("---------BÖLGELER---------");
            System.out.println("1 - GÜVENLİ EV --> Burası sizin için güenli bir alan,DÜŞMAN YOK.");
            System.out.println("2 - EŞYA DÜKKANI --> Silah veya Zırh satın alabilirisin.");
            System.out.println("3 - MAĞARA --> ÖDÜL🏆 <YEMEK🍖🍗🥩>, dikkatli ol ZOMBİE çıkabilir...");
            System.out.println("4 - ORMAN  --> ÖDÜL🏆 <ODUN>, dikkatli ol VAMPİR çıkabilir...");
            System.out.println("5 - NEHİR  --> ÖDÜL🏆 <SU🥛🧊>, dikkatli ol AYI çıkabilir...");
            System.out.println("0 - ÇIKIŞ YAP --> Macera oyununu sonlandır.");
            System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz --> ");
            int selectLocation = input.nextInt();//Scanner sınıfını üstte önceden tanımlamıştım o yüzden tekrar gerek yok.
            switch (selectLocation)
            {
                case 0:
                    location =null;
                    break;
                case 1:
                    location=new SafeHouse(player);//polimorfiz uyguladım ve locationun safehouse gibi davranmasını sağladım.
                    break;
                case 2:
                    location=new ToolStore(player);// Hangi oyuncu varsa onu Toolstora atıyorum.yani player nesnesini içine attım çünkü oyuncunun canı,sağlığı,paraları gibi durumları ele almam lazım.
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;

                default:
                    System.out.println(" LÜTFEN GEÇERLİ BİR BÖLGE GİRİNİZ.!!!");
            }
            if (location==null)
            {
                System.out.println("😒😒😒 MACERA DOLU ADADAN ÇABUK VAZGEÇTİN 😒😒😒");
                break;
            }
            if (!location.onLocation())//onLocation tüm Lokasyonlarda ortak. Hangi lokasyon seçilirse onun override edilmiş onLocationu gelir.
            {
                System.out.println("❌❌❌❌GAME OVER❌❌❌❌");
                break;
            }


        }



    }


}
