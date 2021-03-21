package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.*;

//     https://pokemondb.net/move/dream-eater
public class DreamEater extends SpecialMove {
    public DreamEater() {
        super(Type.PSYCHIC, 100, 100);
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        if (def.getCondition() == Status.SLEEP) {
            return super.checkAccuracy(att, def);
        } else {
            return false;
        }

    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, -(int) (100 - p.getHP()) / 2);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe(){
        return "атакует (Dream Eater)";
    }
}