package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Feature;

public class Liftable implements Feature {
    public static String name = "Liftable";
    private boolean isLifted;

    public void setIsLifted(Boolean isLifted) {
        this.isLifted = isLifted;
    }

    public boolean isLifted() {
        return isLifted;
    }

    @Override
    public String getName() {
        return name;
    }
}
