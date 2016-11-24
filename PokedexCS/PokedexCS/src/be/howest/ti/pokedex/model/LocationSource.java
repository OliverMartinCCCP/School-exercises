package be.howest.ti.pokedex.model;

import java.util.List;

public interface LocationSource {

    public List<Location> getLocations(Pokemon p);
    
}
