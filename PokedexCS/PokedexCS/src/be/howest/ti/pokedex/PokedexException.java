package be.howest.ti.pokedex;

public class PokedexException extends RuntimeException {

    public PokedexException(String msg) {
        super(msg);
    }

    public PokedexException(String msg, Throwable cause) {
        super(msg,cause);
    }
    
}
