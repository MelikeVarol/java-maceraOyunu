package org.example;

public abstract class NormalLoc extends Location{

    public NormalLoc(Player player,String name)
    {
        super(player,name);
    }

    //Abstract metotlar, sınıfın alt sınıfları tarafından implemente edilmek (gerçekleştirilmek) zorundadır.
    // Bu durumda, abstract sınıf içinde tanımlanan abstract metotları alt sınıflar override ederek gerçekleştirir.
    @Override
    public boolean onLocation() {
        return true;//Normal Locationda ölme ihtimalim yok.
    }
}
