package ru.senina.ifmo.Laba3Story;

public class Fact {
    private final Thought thougth;

    Fact(Thought thought){
        this.thougth = thought;
    }

    public String getFact(){
        return this.thougth.getMeaning();
    }
}
