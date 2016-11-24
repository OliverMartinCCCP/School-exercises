package be.howest.ti.pokedex.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class AbstractEncounterPanel extends JPanel {
    
    /*
     * this JPanel contains a WorldPanel and a PokemonSelectPanel
     *  - it can be used to input encounters: see subclass ReportEncounterPanel
     *  - it can be used to visualise encounters: see subclass OverviewEncounterPanel
     */
    
    protected WorldPanel         pnlLocation;
    protected PokemonSelectPanel pnlPokemon;

    public AbstractEncounterPanel(){
        pnlLocation = new WorldPanel();
        pnlPokemon = new PokemonSelectPanel();
        
        this.setLayout(new BorderLayout());
        this.add(pnlLocation,BorderLayout.CENTER);
        this.add(pnlPokemon,BorderLayout.EAST);
    }
    
}
