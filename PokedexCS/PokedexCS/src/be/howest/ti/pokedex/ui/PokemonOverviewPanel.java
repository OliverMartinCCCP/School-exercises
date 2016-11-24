package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Pokemon;
import java.awt.Component;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PokemonOverviewPanel extends JPanel{

    public PokemonOverviewPanel(){
        this(Pokemon.asList());
    }
    
    public PokemonOverviewPanel(Collection<Pokemon> c){
        super();
        init(c);
    }
    
    public PokemonOverviewPanel(Map<Pokemon,Component> map){
        super();
        init(map);
    }
    
    public void setPokemon(Collection<Pokemon> c){
        init(c);
        repaint();
    }

    private void init(Map<Pokemon, Component> map) {
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for(Map.Entry<Pokemon,Component> e : map.entrySet()){
            
            Component x = e.getValue();
            if (x!=null){
                JPanel pnlI = new JPanel();
            pnlI.setLayout(new BoxLayout(pnlI, BoxLayout.LINE_AXIS));
            pnlI.add(new PokemonLabel(e.getKey(),true,25));
            pnlI.add(x);
            this.add(pnlI);
            } else {
                this.add(new PokemonLabel(e.getKey(),true,15));
            }
            
        }
    }

    private void init(Collection<Pokemon> c) {
        Map<Pokemon,Component> map = new LinkedHashMap<>();
        Random r = new Random();
        for(Pokemon p: c){
            JCheckBox cb = new JCheckBox();
            cb.setSelected(r.nextBoolean());
            cb.setEnabled(false);
            map.put(p,null);
        }
        init(map);
    }
    
}
