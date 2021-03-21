package ru.senina.ifmo.Laba3Story;

import ru.senina.ifmo.Laba3Story.creatures.Somebody;

public class Wave{
    private final String name = "wave";

    void sweep(Somebody somebody){
        somebody.setIsSweptAway(true);
        System.out.println(somebody.getName() + " was swept away by a " + name + ".");
   }
}

