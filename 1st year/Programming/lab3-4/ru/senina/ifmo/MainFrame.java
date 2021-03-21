package ru.senina.ifmo.Laba3Story;

import ru.senina.ifmo.Laba3Story.creatures.*;


public class MainFrame {
    public static void preambula(){
        class StoryTaller{
            public final String name;
            public final String surname;
            public final int year;
            StoryTaller(String name, String surname, int year){
                this.name = name;
                this.surname = surname;
                this.year = year;
            }

            @Override
            public String toString() {
                return name + " " + surname + " in " + year;
            }

        }
        System.out.println("This is story from Mumitrolls book.");
        System.out.println("It's author is " + (new StoryTaller("Tove", "Jansson", 1949)).toString() + ".");
        System.out.println("And it was retelled by " + (new StoryTaller("Mariia", "Senina", 2020)).toString() + ".");
        System.out.println();
    }

    public static void main(String[] args) {
        preambula();
        int numOfKids = 2;
        int numOfOtherViewers = 2;
        int numOfTickets = 9;
        Stage stage = new Stage();
        Sets sets = new Sets();
        LivingRoom livingRoom = new LivingRoom();
        DinnerTable dinnerTable = new DinnerTable(livingRoom);
        Smusmumrik smusmumrik = new Smusmumrik(sets);
        smusmumrik.setTicket(new Ticket(dinnerTable));
        Child[] children = new Child[numOfKids];
        OtherViewer[] otherViewers = new OtherViewer[numOfOtherViewers];
        for (int i = 0; i < numOfKids; i++) {
            children[i] = new Child("Child_" + (i + 1), sets);
            children[i].setTicket(new Ticket(dinnerTable));
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i] = new OtherViewer("OtherViewer_" + (i + 1), sets);
            otherViewers[i].setTicket(new Ticket(dinnerTable));
        }
        Mumla mu = new Mumla("Little Mu", sets, TypeOfSpeach.SPEAK_NORMALLY);
        mu.setTicket(new Ticket(dinnerTable));
        Mumla mumla = new Mumla("Mumla", stage, TypeOfSpeach.RECITES_WITH_HEXAMETR);
        mumla.setTicket(new Ticket(dinnerTable));
        Lion lion = new Lion("Lion", stage, TypeOfSpeach.RECITES_WITH_HEXAMETR);
        lion.setTicket(new Ticket(dinnerTable));

        // THE ACTION STARTS HERE
        Thought itIsNotRealLion = new Thought("It's not a real Lion. It's an actor.");
        smusmumrik.say(itIsNotRealLion);

        for (int i = 0; i < numOfKids; i++) {
            children[i].trust(smusmumrik, itIsNotRealLion);
        }

        FirstAction lionRunAfterMumla = new FirstAction(mumla,lion, stage);
        for (int i = 0; i < numOfKids; i++) {
            children[i].see(lionRunAfterMumla);
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].see(lionRunAfterMumla);
        }
        smusmumrik.see(lionRunAfterMumla);
        mu.see(lionRunAfterMumla);

        mu.shout(VoiceQuality.LOUD);
        mu.setMood(Mood.DESPAIR);
        mu.jumpTo(stage);
        mu.runTo(lion);
        mu.bit(lion, lion.getLeg("back left leg"));

        mumla.lift(mu);
        mu.kiss(mumla, mumla.getMuzzle());

        Fact nobodySpeaksWithHexametr = new Fact(new Thought("Nobody speaks" +
                " with Hexametr"));
        for (int i = 0; i < numOfKids; i++) {
            children[i].notice(nobodySpeaksWithHexametr);
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].notice(nobodySpeaksWithHexametr);
        }
        smusmumrik.notice(nobodySpeaksWithHexametr);

        Play play = new Play();
        Play.plot();

        for (int i = 0; i < numOfKids; i++) {
            children[i].understandPlay(play);
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].understandPlay(play);
        }
        smusmumrik.understandPlay(play);

        for (int i = 0; i < numOfKids; i++) {
            children[i].setMood(Mood.EXTREMELY_HAPPY);
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].setMood(Mood.EXTREMELY_HAPPY);
        }
        smusmumrik.setMood(Mood.EXTREMELY_HAPPY);
        mu.setMood(Mood.EXTREMELY_HAPPY);
        mumla.setMood(Mood.EXTREMELY_HAPPY);
        lion.setMood(Mood.EXTREMELY_HAPPY);

        for (int i = 0; i < numOfKids; i++) {
            children[i].setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);
        }
        smusmumrik.setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);
        mu.setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);
        mumla.setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);
        lion.setCondition(Condition.IS_GOING_TO_MAKE_COFFEE);

        for (int i = 0; i < numOfKids; i++) {
            smusmumrik.liftLoPlace(children[i], stage);
        }

        play.vibe = Vibe.FUN;

        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].jumpTo(stage);
        }
        smusmumrik.jumpTo(stage);

        for (int i = 0; i < numOfKids; i++) {
            children[i].eat(children[i].getTicket());
        }
        for (int i = 0; i < numOfOtherViewers; i++) {
            otherViewers[i].eat(otherViewers[i].getTicket());
        }
        smusmumrik.eat(smusmumrik.getTicket());
        mu.eat(mu.getTicket());
        mumla.eat(mumla.getTicket());
        lion.eat(lion.getTicket());
    }
}



