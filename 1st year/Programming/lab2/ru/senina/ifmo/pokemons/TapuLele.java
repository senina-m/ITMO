package ru.senina.ifmo.Laba2Pokemons.pokemons;
import ru.ifmo.se.pokemon.*;
import ru.senina.ifmo.Laba2Pokemons.attacks.BraveBird;
import ru.senina.ifmo.Laba2Pokemons.attacks.Facade;
import ru.senina.ifmo.Laba2Pokemons.attacks.ThunderWave;
import ru.senina.ifmo.Laba2Pokemons.attacks.Withdraw;


public class TapuLele extends Pokemon {
        public TapuLele(String name, int level){
                super(name, level); //использую конструктор предка
                setStats(70,85, 75, 130, 115,95); //заполняю остальные поля
                setType(Type.PSYCHIC, Type.FAIRY);
                setMove(new Withdraw(), new BraveBird(), new ThunderWave(), new Facade());
     }
}


