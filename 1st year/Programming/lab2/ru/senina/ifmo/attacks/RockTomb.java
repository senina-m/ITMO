package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

//https://pokemondb.net/move/rock-tomb
public class RockTomb extends PhysicalMove {
    public RockTomb() {
        super(Type.ROCK, 60, 95);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -1);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe(){
        return "атакует (Rock Tomb)";
    }
}
