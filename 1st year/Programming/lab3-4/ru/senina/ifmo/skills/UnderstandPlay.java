package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.*;

public class UnderstandPlay implements Feature {
    public static String name = "UnderstandPlay";

    public void understandPlay(Play play, String viewver){
        System.out.println(viewver + " has understood the " + play.getName() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
