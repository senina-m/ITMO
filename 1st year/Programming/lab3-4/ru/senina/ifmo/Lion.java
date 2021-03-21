package ru.senina.ifmo.Laba3Story.creatures;

import ru.senina.ifmo.Laba3Story.*;
import ru.senina.ifmo.Laba3Story.skills.JumpToObject;
import ru.senina.ifmo.Laba3Story.skills.RunOnObjectToCreature;
import ru.senina.ifmo.Laba3Story.skills.See;

import java.util.HashMap;
import java.util.Map;

public class Lion extends Creature {
    private Ticket ticket;
    protected Map<String, Leg> legs = new HashMap<>();
    public TypeOfSpeach typeOfSpeach;
    private Mood mood = Mood.NORMAL;
    private Condition condition = Condition.NORMAL;

    public Lion(String name, Place position, TypeOfSpeach typeOfSpeach) {
        super("Lion", position);
        this.typeOfSpeach = typeOfSpeach;
        this.features.put(See.name, new See());
        this.features.put(RunOnObjectToCreature.name, new RunOnObjectToCreature());
        String[] legnames = {"front left leg", "front right leg", "back left leg", "back left leg"};

        for (String legname : legnames) {
            legs.put(legname, new Leg(legname));
        }
    }

    public void setCondition(Condition condition) {
        System.out.println(this.name + " condition turned to " + condition.toString());
        this.condition = condition;
    }

    public Leg getLeg(String leg) {
        return legs.get(leg);
    }

    public void see(SomeAction action){
        ((See) features.get(See.name)).see(action, this.name);
    }

    static class Leg extends PartOfBody {
        protected Boolean hearts = false;
        public Leg(String name) {
            super(name);
        }
    }

    public void setTicketPlace(Table table) {
        this.ticket.setTable(table);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void runOnobjectToCreature(Creature creature, Place place){
        ((RunOnObjectToCreature) features.get(RunOnObjectToCreature.name)).runOnObjectToCreature(creature, place ,this.name);
    }

    public void jumpTo(Place place){
        ((JumpToObject) features.get(JumpToObject.name)).jumpToObject(this, place);
    }


}
