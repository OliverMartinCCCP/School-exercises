package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Encounter;
import be.howest.ti.pokedex.model.Location;
import be.howest.ti.pokedex.model.Pokemon;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ReportEncounterPanel extends AbstractEncounterPanel {
    
    private Encounter encounter = null;
    
    public ReportEncounterPanel(){
        super();
        JButton add = new JButton("Add");
        add.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reportEncounter();
            }
        } );
        
        pnlLocation.setSize(5);
        
        this.pnlLocation.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setInputLocation( new Location(e.getX(), e.getY() ) );
            }
        });
        
        this.add(add,BorderLayout.SOUTH);
        
    }
    
    public void setInputLocation(Location l){
        pnlLocation.setWorldLocation(l);
    }

    public Location getSelectedLocation() {
        for (Location l : pnlLocation.locations) {
            return l;
        }
        return null;
    }

    public void reportEncounter() {
        Location l  = getSelectedLocation();
        Pokemon p  = pnlPokemon.getPokemon();
        
        if (l==null){
            JOptionPane.showMessageDialog(this,"You needs to click on a location.","Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (p==null){
            JOptionPane.showMessageDialog(this,"You needs to select a pokemon.","Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Encounter oldEncounter = encounter;
        encounter = new Encounter(p, l);
        
        this.firePropertyChange("encounter", oldEncounter, encounter);
        
    }
    
}
