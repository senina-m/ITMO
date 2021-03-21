package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.*;

// https://pokemondb.net/move/swagger
public class Swagger extends StatusMove {
    public Swagger(){
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.confuse(p);
        p.setMod(Stat.ATTACK, 2);
        super.applyOppEffects(p);
    }

    protected String describe(){
        return "атакует (Swagger) - запутывает соперника";
    }

}
