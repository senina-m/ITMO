package ru.senina.ifmo.Laba3Story;

public class Ticket extends Eeatable{
    private Table table;

    protected Ticket(Table table) {
        super("Ticket", 5);
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
