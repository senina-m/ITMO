package ru.senina.ifmo.Laba3Story.creatures;

import ru.senina.ifmo.Laba3Story.*;
import ru.senina.ifmo.Laba3Story.skills.*;

public class Child extends Creature{
    private Fact lastUnderstoodFact;
    private Ticket ticket;
    private Condition condition = Condition.NORMAL;
    private Mood mood = Mood.NORMAL;
    public Child(String name, Place position) {
        super(name, position);
        this.features.put(Liftable.name, new Liftable());
        this.features.put(See.name, new See());
        this.features.put(Notice.name, new Notice());
        this.features.put(UnderstandPlay.name, new UnderstandPlay());
    }

    //TODO: the Distrustful Statements(class) to make child trust all Smusmumiks except some cases.
    //Получается что малыш будет недоверять всем Смусмумрикам.
    // Но вроде Смусмумрик в сказке только один.

    public void trust(Creature creature, Thought thought) {
        if (creature.getClass() == Smusmumrik.class && thought.getMeaning().equals("It's not a real Lion. It's an actor.")) {
            System.out.println(this.name + " don't trust " + creature.getName() + ".");
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

    public void setCondition(Condition condition) {
        System.out.println(this.name + " condition turned to " + condition.toString());
        this.condition = condition;
    }

    public void understandPlay(Play play){
        if((lastUnderstoodFact.getFact()).equals("Nobody speaks with Hexametr")) {
            ((UnderstandPlay) features.get(UnderstandPlay.name)).understandPlay(play, this.name);
        }else{
            System.out.println(this.name + "didn't understood the " + play.getName() + ".");
        }
    }

    public void notice(Fact fact){
        ((Notice) features.get(Notice.name)).notice(fact, this.name);
        this.lastUnderstoodFact = fact;
    }

    public void see(SomeAction action){
        ((See) features.get(See.name)).see(action, this.name);
    }

    public void setIsLifted(Boolean isLifted) {
        ((Liftable)features.get(Liftable.name)).setIsLifted(isLifted);
    }
}
