package be.howest.ti.pokedex.model;

public class Encounter {

    private final Pokemon p;
    private final Location l;

    public Encounter(Pokemon p, Location l) {
        this.p = p;
        this.l = l;
    }

    public Pokemon getPokemon() {
        return p;
    }

    public Location getLocation() {
        return l;
    }

}
