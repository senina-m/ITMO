package ru.senina.ifmo.Laba3Story;

public class Home extends Place{
    protected Creature owner;
    Home(){
        super("Home");
    }

    public void setOwner(Creature owner) {
        this.owner = owner;
    }
}
