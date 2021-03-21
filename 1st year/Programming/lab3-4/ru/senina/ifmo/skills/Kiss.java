package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Creature;
import ru.senina.ifmo.Laba3Story.Feature;
import ru.senina.ifmo.Laba3Story.KissablePlace;

public class Kiss implements Feature {
    public static String name = "Kiss";

    public void kiss(Creature creature, KissablePlace kissablePlace, String kisser) {
        System.out.println(kisser + " has kissed " + creature.getName() + "'s "
                + kissablePlace.getPartOfBodyName() + ".");
    }

    @Override
    public String getName() {
        return name;
    }
}
