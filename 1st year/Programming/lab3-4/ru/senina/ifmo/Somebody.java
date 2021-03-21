package ru.senina.ifmo.Laba3Story.creatures;
import ru.senina.ifmo.Laba3Story.*;

public class Somebody extends Creature {
    public Somebody(Place position) {
        super("Somebody", position);
    }
    private boolean isSweptAway = false;

    public void comeSomewhere(Place place){
        System.out.println(name + " finally came " + place.getName() + ".");
    }

    public void setIsSweptAway(boolean var){
        isSweptAway = var;
    }

    public void getIntoScaryAdventures(){
        System.out.println(name + " got into a scary adventures.");
    }

    public void surviveInScaryAdventures(){
        System.out.println(name + " survived in the scary adventures.");
    }
}