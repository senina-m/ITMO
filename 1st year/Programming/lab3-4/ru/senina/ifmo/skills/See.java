package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Feature;
import ru.senina.ifmo.Laba3Story.SomeAction;

public class See implements Feature {
    public static String name = "See";

    public void see(SomeAction action, String viewer){
        System.out.print(viewer + " saw how ");
        action.run();
    }

    @Override
    public String getName() {
        return name;
    }
}
