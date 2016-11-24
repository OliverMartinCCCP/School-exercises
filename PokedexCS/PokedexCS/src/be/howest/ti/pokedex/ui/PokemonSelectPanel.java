package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Pokemon;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PokemonSelectPanel extends JPanel {
    
    /*
    * This JPanel shows a picture and name of the currently selected pokemon.
    * Below this picture there is a input field, which accepts numbers between 0 and 150.
    * Left and right of this input field there is a button to increment of decrements the input, respectively.
    * Changing the number (buttons or typing) causes a different pokemon to be selected.
    *
    * getPokemon() returns the currently selected pokemon as a Java object.
    */

    private Pokemon p;
    private PokemonLabel label;
    private final JTextField txtfPokemonId;

    public Pokemon getPokemon() {
        return p;
    }


    public PokemonSelectPanel() {
        txtfPokemonId = new JTextField("0",3);
        txtfPokemonId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idChanged();
            }
        });

        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        JButton btnPrev = new JButton("<<");
        btnPrev.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setId(getCurrentId() - 1);
                idChanged();
            }
        }
        );
        JButton btnNext = new JButton(">>");
        btnNext.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setId(getCurrentId() + 1);
                idChanged();
            }
        }
        );

        JPanel temp = new JPanel();
        temp.setLayout(new FlowLayout());
        temp.add(btnPrev);
        temp.add(txtfPokemonId);
        temp.add(btnNext);

        label = new PokemonLabel(null, false,(int)temp.getPreferredSize().getWidth()/2);
        this.add(label);
        this.add(temp);
        
        
        
        
        setId(0);

    }

    private void setId(int id) {
        if (id >= 0 && id <= Pokemon.COUNT) {
            String old = txtfPokemonId.getText();
            String njew = "" + id;
            if (!old.equals(njew)) {
                txtfPokemonId.setText("" + id);
            }
        }
        // else: ignore (id is not oke).
    }

    private int getCurrentId() {
        int id = Integer.parseInt(txtfPokemonId.getText());
        if (id >= 0 && id <= Pokemon.COUNT) {
            return id;
        } else {
            throw new RuntimeException("Out of bounds");
        }
    }

    public void idChanged() {
        try {
            Pokemon oldP = getPokemon();
            Pokemon newP = Pokemon.get(getCurrentId());
            p = newP;
            label.setPokemon(newP);
            this.firePropertyChange("pokemon", oldP, newP);
        } catch (RuntimeException e) {
            if (getPokemon() != null) {
                setId(getPokemon().getId());
            } else {
                setId(0);
            }
        }

    }

}
