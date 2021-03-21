package ru.senina.ifmo.Laba3Story;

import ru.senina.ifmo.Laba3Story.creatures.Somebody;

public class Play {
    private String name = "Play about Someone";
    public Vibe vibe = Vibe.NORMAL;

    public static void plot() {
        Home somebodyHome = new Home();
        Somebody somebody = new Somebody(somebodyHome);
        somebodyHome.setOwner(somebody);
        System.out.println("\n" + "The play told about " + somebody.getName() + ".");
        Wave hugeWave = new Wave();
        Somewhere somewhere = new Somewhere();
        hugeWave.sweep(somebody);
        somebody.getIntoScaryAdventures();
        somebody.surviveInScaryAdventures();
        somebody.comeSomewhere(somebodyHome);
    }

    public String getName() {
        return name;
    }
}
