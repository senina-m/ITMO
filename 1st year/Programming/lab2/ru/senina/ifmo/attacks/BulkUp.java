package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

//    https://pokemondb.net/move/bulk-up
public class BulkUp extends StatusMove {
    public BulkUp(){
        super(Type.FIGHTING, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK, 1);
        p.setMod(Stat.DEFENSE, 1);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe(){
        return "атакует (Bulk Up)";
    }
}
