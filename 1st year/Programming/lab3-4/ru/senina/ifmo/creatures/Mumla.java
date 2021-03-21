package ru.senina.ifmo.Laba3Story.creatures;
import ru.senina.ifmo.Laba3Story.*;
import ru.senina.ifmo.Laba3Story.skills.*;

public class Mumla extends Creature{
    private Ticket ticket;
    public TypeOfSpeach typeOfSpeach;
    private final Teeth teeth = new Teeth(this.name + "'s teeth");
    private final Mumla.Muzzle muzzle = new Muzzle( this.name + "'s muzzle");
    private Condition condition = Condition.NORMAL;
    public Mumla(String name, Place position, TypeOfSpeach typeOfSpeach) {
        super(name, position);
        this.typeOfSpeach = typeOfSpeach;
        this.features.put(Lift.name, new Lift());
        this.features.put(Liftable.name, new Liftable());
        this.features.put(Bit.name, new Bit());
        this.features.put(Shout.name, new Shout());
        this.features.put(RunToObject.name, new RunToObject());
        this.features.put(RunToCreature.name, new RunToCreature());
        this.features.put(RunOnObjectToCreature.name, new RunOnObjectToCreature());
        this.features.put(JumpToObject.name, new JumpToObject());
        this.features.put(Kiss.name, new Kiss());
        this.features.put(See.name, new See());
    }

    public void see(SomeAction action){
        ((See) features.get(See.name)).see(action, this.name);
    }

    public Mumla.Muzzle getMuzzle() {
        return muzzle;
    }

    public void kiss(Creature creature, KissablePlace kissablePlace) {
        ((Kiss) features.get(Kiss.name)).kiss(creature, kissablePlace, this.name);
    }

    public void setCondition(Condition condition) {
        System.out.println(this.name + " condition turned to " + condition.toString());
        this.condition = condition;
    }

    public void shout(VoiceQuality quality) {
        if (quality.equals(VoiceQuality.LOUD)) {
            Mumla.Throat throat = new Mumla.Throat();
            System.out.println(this.name + " was shouting with full " + throat.getPartOfBodyName() + ".");
        } else {
            if (quality.equals(VoiceQuality.QUIET)) {
                System.out.println(this.name + " was shouting " + quality.toString() + ".");
            }
        }
        ((Shout)features.get(Shout.name)).shout();
    }

    public void jumpTo(Place place){
        ((JumpToObject) features.get(JumpToObject.name)).jumpToObject(this, place);
    }

    public void runTo(Creature creature){
        ((RunToCreature) features.get(RunToCreature.name)).runToCreature(creature, this.name);
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

    public void bit(Creature creature, PartOfBody partOfBody){
        try {
            ((Bit) features.get(Bit.name)).bit(creature, partOfBody, this.teeth, this);
        }catch (NotInOnePlaceException e){
            System.out.println("!!!!" + creature.getName() + " is in different positions with " + this.name + "!!!!");
            this.runTo(creature);
            System.out.println( this.name + " run to " + creature.getName() + " but didn't bitten it, try again! ");
        }finally {
            System.out.println("Сhill...");
        }
    }

    public void lift(Creature creature) {
        if(creature.thereIsFeature(Liftable.name)){
            Liftable featureLiftable = (Liftable) creature.getFeature(Liftable.name);
            ((Lift) features.get(Lift.name)).lift(featureLiftable, this.name, creature.getName());
        }
    }

    class Throat extends PartOfBody{
        public Throat() {
            super(Mumla.this.getName() + "'s throat");
        }
    }


    static class Muzzle extends PartOfBody implements KissablePlace {
        Muzzle(String owner) {
            super(owner);
        }
    }

    static class Teeth extends PartOfBody {
        public Teeth(String partOfBodyName ) {
            super(partOfBodyName);
        }
    }
}

