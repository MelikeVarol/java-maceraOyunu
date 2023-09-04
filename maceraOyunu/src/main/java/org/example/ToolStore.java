package org.example;

public class ToolStore extends NormalLoc{

    public ToolStore(Player player)
    {
        super(player,"MAĞAZA ");
    }

    @Override
    public boolean onLocation()
    {
        System.out.println("🏩 MAĞAZAYA HOŞGELDİNİZ 🏩");
        boolean showMenu=true;
        while (showMenu)
        {
            System.out.println("1- SİLAHLAR 🔫🔫🔫🔫🔫");
            System.out.println("2- ZIRHLAR ");
            System.out.println("3- ÇIKIŞ YAP");
            System.out.print("SEÇİMİNİZ: ");
            int selectCase=input.nextInt() ;//input atasınıfım olan Locationdan geliyor.
            while (selectCase<1 && selectCase>3)
            {
                System.out.print("----Geçersiz bir değer girdiniz tekrar deneyin----");
                selectCase=input.nextInt();

            }
            switch (selectCase)
            {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;

                case 3:
                    System.out.println("🖐🖐GÜLE GÜLE BİR DAHA BEKLERİZ🖐🖐");
                    showMenu=false;
                    break;
            }
        }

        return true;
    }
    public  void printWeapon()//   EKRANA SİLAHLARI BASTIRMAK İÇİN
    {
        System.out.println("🔫🔫🔫Silahlar🔫🔫🔫");
        for (Weapon w: Weapon.weapons())
        {
            System.out.println(w.getId()+w.getName() + " <Para : " + w.getPrice() + ", Hasar : " + w.getDamage()+">");
        }
        System.out.println("0 - ÇIKIŞ YAP 👋👋");

    }

    public  void buyWeapon()
    {
        System.out.print("BİR SİLAH SEÇİNİZ--->");
        int selectWeaponID=input.nextInt();
        while (selectWeaponID<0 || selectWeaponID>Weapon.weapons().length)
        {
            System.out.print("----Geçersiz bir değer girdiniz tekrar deneyin----");
            selectWeaponID=input.nextInt();
        }
        if (selectWeaponID !=0)
        {
            Weapon selectedWeapon= Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null)
            {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney())
                {
                    System.out.println("❌❌❌Yeterli Paranız Bulunmamaktadır.❌❌❌");
                }
                else
                {
                    //Satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız...");
                    int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("💰💰💰💰KALAN BAKİYENİZ 💰💰💰💰 --> " +this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("YENİ Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }



    }


    public void printArmor()
    {
        System.out.println("🛡🛡🛡🛡Zırhlar🛡🛡🛡🛡");
        //for each ile Armor vei tipini döndüren a isminde yeni bir nesne aldım.Ve bu da Armor classımın armors metodunu döndürüyor.
        for (Armor a:Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    "< Para : "+a.getPrice()+
                    " Zırh Değeri :"+a.getBlock()+" >" );
        }

        System.out.println("0 - ÇIKIŞ YAP 👋👋");

    }
    public  void buyArmor()
    {
        System.out.print("BİR ZIRH SEÇİNİZ--->");
        int selectArmorID=input.nextInt();
        while (selectArmorID<0 || selectArmorID>Armor.armors().length)
        {
            System.out.print("❌❌❌Geçersiz bir değer girdiniz tekrar deneyin❌❌❌---->");
            selectArmorID=input.nextInt();
        }

        if (selectArmorID !=0 )//0 seçilmediyse bu işlemleri yapar.
        {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);//Liste içeriisnden obje alıyorum.
            if (selectedArmor != null)//Yani bir değer bulunduysa yanlış bir değer girilmediyse.
            {
                if (selectedArmor.getPrice()>this.getPlayer().getMoney())
                {
                    System.out.println("❌❌❌Yeterli Paranız Bulunmamaktadır.❌❌❌");

                }
                else
                {
                    //Sayın alma işlemi
                    System.out.println(selectedArmor.getName()+ "zırhını satın aldınız.");
                    int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);//setArmoru benim seçtiğim armorla değiştirmem lazım obje olarak
                    System.out.println("💰💰💰💰KALAN BAKİYENİZ 💰💰💰💰 --> " +this.getPlayer().getMoney());

                }
            }
        }
    }


}
