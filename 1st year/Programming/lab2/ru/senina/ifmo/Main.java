package ru.senina.ifmo.Laba2Pokemons;
import ru.ifmo.se.pokemon.*;
import ru.senina.ifmo.Laba2Pokemons.pokemons.*;

public class Main{
    public static void main(String[] args){
        Battle b = new Battle();
        Darmanitan p1 = new Darmanitan("1", 1);
        Darumaka p2 = new Darumaka("2", 1);
        TapuLele p3 = new TapuLele("3", 1);
        Togekiss p4 = new Togekiss("4", 1);
        Togepi p5 = new Togepi("5", 1);
        Togetic p6 = new Togetic("6", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
