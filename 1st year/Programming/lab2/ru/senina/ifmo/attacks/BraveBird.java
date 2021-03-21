package ru.senina.ifmo.Laba2Pokemons.attacks;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

// https://pokemondb.net/move/brave-bird
public class BraveBird extends PhysicalMove {
    public BraveBird() {
        super(Type.FLYING, 120, 100);
    }

    @Override
    protected void applySelfDamage(Pokemon p, double damage) {
        p.setMod(Stat.HP, (int) ((1 / 3) * damage));
        super.applySelfDamage(p, damage);
    }

    @Override
    protected String describe(){
        return "атакует (Brave Bird)";
    }
}
