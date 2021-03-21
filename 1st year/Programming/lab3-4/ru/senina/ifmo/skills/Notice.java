package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.*;

public class Notice implements Feature {
    public static String name = "Notice";

    public void notice(Fact fact, String noticer) {
        System.out.println(noticer + " noticed the fact: " + fact.getFact() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
