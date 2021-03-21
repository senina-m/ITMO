package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Creature;
import ru.senina.ifmo.Laba3Story.Feature;
import ru.senina.ifmo.Laba3Story.Place;

public class RunOnObjectToCreature implements Feature {
    public static String name = "RunOnObjectToCreature";

    public void runOnObjectToCreature(Creature creature, Place place, String runner){
        System.out.println(runner + " run to " + creature.getName() + " on the " + place.getName() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
