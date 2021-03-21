package ru.senina.ifmo.Laba3Story;

import ru.senina.ifmo.Laba3Story.creatures.Lion;
import ru.senina.ifmo.Laba3Story.creatures.Mumla;

public class FirstAction extends SomeAction {
    protected Mumla mumla;
    protected Lion lion;
    protected Place place;

    FirstAction(Mumla mumla, Lion lion, Place place) {
        this.mumla = mumla;
        this.lion = lion;
        this.place = place;
    }

    @Override
    public void run() {
        lion.runOnobjectToCreature(mumla, place);
    }
}
