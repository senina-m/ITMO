package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Creature;
import ru.senina.ifmo.Laba3Story.Feature;

public class RunToCreature implements Feature {
    public static String name = "RunToCreature";

    public void runToCreature(Creature creature, String runner){
        System.out.println(runner + " run to " + creature.getName() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
