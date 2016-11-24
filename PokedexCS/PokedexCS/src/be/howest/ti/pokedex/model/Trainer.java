package be.howest.ti.pokedex.model;

import be.howest.ti.pokedex.data.TrainerDA;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Trainer implements Serializable {
    
    private final String name;
    private final Set<Pokemon> seen = new HashSet<>();
    private int pokeballs = 0;
    
    public Trainer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Pokemon> getSeen() {
        return seen;
    }
    
    public void encounter(Pokemon p, Location l){
        seen.add(p);
        TrainerDA.instance.save(Trainer.this);
        p.addEncounter(l);
    }
    
    public boolean hasSeen(Pokemon p){
        return seen.contains(p);
    }
    
    public void addPokeball(){
        pokeballs++;
        TrainerDA.instance.save(Trainer.this);
    }

    public int getPokeballs() {
        return pokeballs;
    }
    
}
