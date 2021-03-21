package ru.senina.ifmo.Laba3Story.creatures;
import ru.senina.ifmo.Laba3Story.*;
import ru.senina.ifmo.Laba3Story.skills.*;

public class Smusmumrik extends Creature{
    private Ticket ticket;
    private Fact lastUnderstoodFact;
    private Condition condition = Condition.NORMAL;
    private Mood mood = Mood.NORMAL;
    public Smusmumrik(Place position) {
        super("Smusmumrik", position);
    }

    public void say(Thought thought){
        System.out.println(this.name + " said:\" " + thought.getMeaning() + "\"");
        this.features.put(See.name, new See());
        this.features.put(Notice.name, new Notice());
        this.features.put(UnderstandPlay.name, new UnderstandPlay());
        this.features.put(Lift.name, new Lift());
        this.features.put(JumpToObject.name, new JumpToObject());
    }

    public void setCondition(Condition condition) {
        System.out.println(this.name + " condition turned to " + condition.toString());
        this.condition = condition;
    }

    public void see(SomeAction action){
        ((See) features.get(See.name)).see(action, this.name);
    }

    public void notice(Fact fact){
        ((Notice) features.get(Notice.name)).notice(fact, this.name);
        this.lastUnderstoodFact = fact;
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

    public void jumpTo(Place place){
        ((JumpToObject) features.get(JumpToObject.name)).jumpToObject(this, place);
    }

    public void understandPlay(Play play){
        if(lastUnderstoodFact.getFact().equals("Nobody speaks with Hexametr")) {
            ((UnderstandPlay) features.get(UnderstandPlay.name)).understandPlay(play, this.name);
        }else{
            System.out.println(this.name + "didn't understood the " + play.getName() + ".");
        }
    }

    public void liftLoPlace(Creature creature, Place place){
        if(creature.thereIsFeature(Liftable.name)){
            Liftable featureLiftable = (Liftable) creature.getFeature(Liftable.name);
            ((Lift) features.get(Lift.name)).lift(featureLiftable, this.name, creature.getName());
        }
        creature.setPosition(place);
    }
}
