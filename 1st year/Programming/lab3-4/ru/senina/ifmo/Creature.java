package ru.senina.ifmo.Laba3Story;

import java.util.*;


public abstract class Creature{
    protected String name;
    protected int energyLevel = 80;
    protected Place position;
    protected Boolean isBroken = false;
    protected Map<String, Feature> features = new HashMap<>();
    protected Mood mood = Mood.NORMAL;

    protected Creature(String name, Place position){
        this.name = name;
        this.position = position;
    }

    public void setPosition(Place position){
        this.position = position;
    }

    public Place getPosition(){
        return this.position;
    }

    public String getName() {
        return name;
    }

    public boolean thereIsFeature(String featureName){
        return features.containsKey(featureName);
    }

    public Feature getFeature(String featureName){
        return features.get(featureName);
    }


    public Mood getMood(){return mood;}
    public void setMood(Mood mood){
        this.mood = mood;
        System.out.println("Mood of " + this.name + " turned to " + mood.toString() + ".");
    }

    public void eat(Eeatable food){
        this.energyLevel += food.getValue();
        if(energyLevel >= 100){
            throw new EatTooMuchException();
        }
        System.out.println(this.getName() + " has eaten " + food.getName() + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return name.equals(creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setIsBroken(boolean b){
        if(!b){
            System.out.println(this.name + " was treated and now is Okey.");
        }else{
            System.out.println(this.name + " was broke down.");
        }
        isBroken = b;
    };
}




