package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.LocationSource;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;

public class OverviewEncounterPanel
        extends AbstractEncounterPanel
        implements PropertyChangeListener {
    
    LocationSource locationSource = null;
    
    public OverviewEncounterPanel(){
        super();
        pnlPokemon.addPropertyChangeListener("pokemon", this);
    }
    
    public void setLocationSource(LocationSource locationSource){
        this.locationSource = locationSource;
    } 

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (locationSource !=null && evt.getSource()==pnlPokemon) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    OverviewEncounterPanel.this.pnlLocation.setWorldLocations(locationSource.getLocations(pnlPokemon.getPokemon()));
                }
            });
            
        }
    }

}
