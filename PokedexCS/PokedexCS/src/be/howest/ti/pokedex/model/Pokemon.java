package be.howest.ti.pokedex.model;

import be.howest.ti.pokedex.data.PokemonDA;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class Pokemon implements Serializable {
    
    public static final int COUNT = 150;
    
    private static final Pokemon[] POKEMON_CACHE = new Pokemon[COUNT];
    
    public static Pokemon get(int i){
        if (i==0) return null;
        if (POKEMON_CACHE[i-1]==null)
            POKEMON_CACHE[i-1] = PokemonDA.instance.loadPokemon(i);
        return POKEMON_CACHE[i-1];
    }

    public static List<Pokemon> asList() {
        return Arrays.asList(POKEMON_CACHE);
    }
    
    final int id;
    final String name;
    
    public Pokemon(int id, String name){
        this.id   = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String toString(){
        return  String.format("%s (%d)", getName(),getId());
    }

    void addEncounter(Location l) {
        PokemonDA.instance.recordEncounter(this, l);
    }

}
