package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/ancient-power
public class AncientPower extends SpecialMove {
    public AncientPower() {
        super(Type.ROCK, 60, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            p.setMod(Stat.ATTACK, 1);
            p.setMod(Stat.DEFENSE, 1);
            p.setMod(Stat.SPECIAL_ATTACK, 1);
            p.setMod(Stat.SPECIAL_DEFENSE, 1);
            p.setMod(Stat.SPEED, 1);
        }
        super.applySelfEffects(p);
    }

    @Override
    protected String describe(){
        return "атакует (Ancient Power)";
    }
}
