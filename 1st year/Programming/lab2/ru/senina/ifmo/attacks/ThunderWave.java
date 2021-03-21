package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

//https://pokemondb.net/move/thunder-wave
public class ThunderWave extends StatusMove {
    public ThunderWave(){
        super(Type.ELECTRIC, 0, 90);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.paralyze(p);
        super.applyOppEffects(p);
    }

    protected String describe(){
        return "атакует (Thunder Wave) - парализует соперника";
    }
}
