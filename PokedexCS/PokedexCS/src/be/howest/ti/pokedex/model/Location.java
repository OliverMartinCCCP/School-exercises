package be.howest.ti.pokedex.model;

import be.howest.ti.pokedex.PokedexException;
import be.howest.ti.pokedex.ui.ImageUtils;
import java.io.Serializable;

public class Location implements Serializable {

    public static final int serialVersionUID = 1;

    private static final int MAX_X = ImageUtils.WOLRD_WIDTH;
    private static final int MAX_Y = ImageUtils.WOLRD_HEIGHT;

    private final int x, y;

    public Location(int x, int y) {
        if (x < 0 || y < 0 || x >= MAX_X || y >= MAX_Y) {
            throw new PokedexException(String.format("Invalid location %d,%d", x, y));
        }
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return ((MAX_X * y) + x);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;

        return ((x == other.x)
                && (y == other.y));

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
