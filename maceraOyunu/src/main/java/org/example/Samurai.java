package org.example;

//polimorfizm kullanım. Sınıfı GameChar ama Samurai gibi davran
public class Samurai extends GameCharacter{
    // extends ettiğim içim GameCharacter constructoru çağırmam gereliyor.
    public Samurai()
    {
        super(1,"SAMURAY ",5,21,15);
    }


}
