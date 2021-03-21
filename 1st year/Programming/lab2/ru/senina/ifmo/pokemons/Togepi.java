package ru.senina.ifmo.Laba2Pokemons.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.senina.ifmo.Laba2Pokemons.attacks.DreamEater;
import ru.senina.ifmo.Laba2Pokemons.attacks.FireBlast;

//https://pokemondb.net/pokedex/togepi
public class Togepi extends Pokemon {
    public Togepi(String name, int level) {
        super(name, level);
        setType(Type.FAIRY);
        setStats(35,20,65,40,65,20);
        setMove(new DreamEater(), new FireBlast());
    }
}
