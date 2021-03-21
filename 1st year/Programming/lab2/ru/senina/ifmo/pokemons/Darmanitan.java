package ru.senina.ifmo.Laba2Pokemons.pokemons;

import ru.senina.ifmo.Laba2Pokemons.attacks.RockTomb;
import ru.senina.ifmo.Laba2Pokemons.attacks.FireBlast;
import ru.senina.ifmo.Laba2Pokemons.attacks.Swagger;


public class Darmanitan extends Darumaka {
    public Darmanitan(String name, int level) {
        super(name, level);
        setStats(105, 140, 55, 30, 55, 95);
        //т.к. этот наследуется от того, что с типом fire этот тоже будет fire
        setMove(new FireBlast(), new RockTomb(), new Swagger());
    }
}
