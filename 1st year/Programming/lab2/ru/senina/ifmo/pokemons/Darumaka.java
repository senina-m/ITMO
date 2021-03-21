package ru.senina.ifmo.Laba2Pokemons.pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.senina.ifmo.Laba2Pokemons.attacks.RockTomb;
import ru.senina.ifmo.Laba2Pokemons.attacks.FireBlast;
import ru.senina.ifmo.Laba2Pokemons.attacks.Swagger;

public class Darumaka extends Pokemon {
    public Darumaka(String name, int level){
        super(name, level);
        setStats(70,90,45, 15, 45,50);
        setType(Type.FIRE);
        setMove(new FireBlast(), new RockTomb(), new Swagger());
    }
}
