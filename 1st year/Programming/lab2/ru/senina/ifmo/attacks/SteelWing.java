package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

//     https://pokemondb.net/move/steel-wing
public class SteelWing extends PhysicalMove {
    public SteelWing() {
        super(Type.STEEL, 70, 90);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if (Math.random() < 0.1) p.setMod(Stat.DEFENSE, 1);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe(){
        return "атакует (Steel Wing)";
    }
}
