package ru.senina.ifmo.Laba3Story.skills;

import ru.senina.ifmo.Laba3Story.Feature;

public class Lift implements Feature {

    public static String name = "Lift";

    public void lift(Liftable liftable, String lifterName, String liftableName) {
        if(liftable.isLifted()){
            System.out.println(liftableName + "is already lifted.");
        }else{
            liftable.setIsLifted(true);
            System.out.println(lifterName + " lifted " + liftableName + ".");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
