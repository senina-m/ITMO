package ru.senina.ifmo.Laba3Story;

public class DinnerTable extends Table{
    private Place position;

    DinnerTable(Place place){
        this.position = place;
    }

    public void setPosition(Place position) {
        this.position = position;
    }

    public Place getPosition() {
        return this.position;
    }
}
