package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Pokemon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PokemonLabel extends JLabel {

    private final int imgSize;
    private final boolean text;

    public PokemonLabel() {
        this(null);
    }

    public PokemonLabel(Pokemon pokemon) {
        this(pokemon, true, 50);
    }

    public PokemonLabel(Pokemon pokemon, boolean text, int imgSize) {
        this.imgSize = imgSize;
        this.text = text;
        setPokemon(pokemon);
    }

    public void setPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            this.setIcon(new ImageIcon(ImageUtils.loadPokemonImage(pokemon, imgSize)));
            if (text) {
                this.setText(pokemon.getName());
            }
        } else {
            this.setIcon(new ImageIcon(ImageUtils.loadPokemonImage(null, imgSize)));
            if (text) {
                this.setText("No Pokemon Selected");
            }
        }
    }

}
