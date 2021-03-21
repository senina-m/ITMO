package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/withdraw
public class Withdraw extends StatusMove {
    public Withdraw(){
        super(Type.WATER, 0, 40);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.DEFENSE, 1);
        super.applySelfEffects(p);
    }

    protected String describe(){
        return "атакует (Withdraw)";
    }
}

