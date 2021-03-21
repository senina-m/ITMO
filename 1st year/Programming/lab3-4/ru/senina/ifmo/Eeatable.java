package ru.senina.ifmo.Laba3Story;

public class Eeatable {
    protected String name;
    protected int energyValue;

    protected Eeatable(String name, int energyValue){
        this.name = name;
        this.energyValue = energyValue;
    }

    public int getValue(){
        return energyValue;
    }

    public String getName(){
        return name;
    }

}
