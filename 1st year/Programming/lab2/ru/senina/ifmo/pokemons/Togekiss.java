package ru.senina.ifmo.Laba2Pokemons.pokemons;

import ru.senina.ifmo.Laba2Pokemons.attacks.SteelWing;
import ru.senina.ifmo.Laba2Pokemons.attacks.AncientPower;
import ru.senina.ifmo.Laba2Pokemons.attacks.DreamEater;
import ru.senina.ifmo.Laba2Pokemons.attacks.FireBlast;
// https://pokemondb.net/pokedex/togekiss

public class Togekiss extends Togetic {
    public Togekiss(String name, int level){
        super(name, level);
        setStats(85, 50,95,120, 115,80);
        setMove(new DreamEater(), new FireBlast(), new AncientPower(), new SteelWing());
    }
}
