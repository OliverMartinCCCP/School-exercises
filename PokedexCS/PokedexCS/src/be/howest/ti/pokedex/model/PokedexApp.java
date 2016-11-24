package be.howest.ti.pokedex.model;

import be.howest.ti.pokedex.data.PokemonDA;
import java.util.List;

public class PokedexApp implements LocationSource {
    
    private final Trainer trainer;
    
    public PokedexApp(Trainer trainer){
        if (trainer == null) throw new RuntimeException("Trainer cannot be null");
        this.trainer = trainer;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public List<Location> getLocations(Pokemon pokemon) {
        return PokemonDA.instance.retrieveEncounters(pokemon);
    }

}
