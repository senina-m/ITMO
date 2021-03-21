package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/facade
public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }

    @Override
    protected double calcBaseDamage(Pokemon p1, Pokemon p2) {
        if ((p2.getCondition() == Status.BURN || p2.getCondition() == Status.POISON) ||
                (p2.getCondition() == Status.PARALYZE)) {
            this.power *= 2;
            double result = super.calcBaseDamage(p1, p2);
            this.power /= 2;
            return result;
        }
        return super.calcBaseDamage(p1, p2);
    }

    @Override
    protected String describe(){
        return "атакует (Facade)";
    }
}
