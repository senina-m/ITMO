package ru.senina.ifmo.Laba2Pokemons.pokemons;

import ru.ifmo.se.pokemon.Type;
import ru.senina.ifmo.Laba2Pokemons.attacks.AncientPower;
import ru.senina.ifmo.Laba2Pokemons.attacks.DreamEater;
import ru.senina.ifmo.Laba2Pokemons.attacks.FireBlast;

//https://pokemondb.net/pokedex/togetic
public class Togetic extends Togepi {
    public Togetic(String name, int level) {
        super(name, level);
        setType(Type.FLYING, Type.FIRE);
        setStats(55,40,85,80,105,40);
        setMove(new DreamEater(), new FireBlast(), new AncientPower());
    }
}
