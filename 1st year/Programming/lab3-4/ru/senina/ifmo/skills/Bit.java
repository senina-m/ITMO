package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.*;

public class Bit implements Feature {
    public static String name = "Bit";

    public void bit(Creature creature, PartOfBody bittablePartOfBody, PartOfBody bittersPartOfBody, Creature bitter) throws NotInOnePlaceException {
        if(creature.getPosition().equals(bitter.getPosition())) {
            System.out.println(bitter.getName() + " bits " + creature.getName() + "'s " +
                    bittablePartOfBody.getPartOfBodyName() + " with " + bittersPartOfBody.getPartOfBodyName() + ".");
            bittablePartOfBody.setHearts();
            creature.setIsBroken(true);
        }else{
            throw new NotInOnePlaceException();
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
