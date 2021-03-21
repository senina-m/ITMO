package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Creature;
import ru.senina.ifmo.Laba3Story.Feature;
import ru.senina.ifmo.Laba3Story.Place;

public class JumpToObject implements Feature {
    public static String name = "JumpToObject";

    public void jumpToObject(Creature jumper, Place place){
        jumper.setPosition(place);
        System.out.println( jumper.getName() + " jump on " + place.getName() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
