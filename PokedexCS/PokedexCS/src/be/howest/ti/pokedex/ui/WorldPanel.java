package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Location;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JPanel;

public class WorldPanel extends JPanel {

    private static final int W = ImageUtils.WOLRD_WIDTH;
    private static final int H = ImageUtils.WOLRD_HEIGHT;

    private int size = 1;

    public void setSize(int size) {
        this.size = size;
    }

    Image area = null;
    protected Collection<Location> locations;

    public WorldPanel() {
        this(new ArrayList<>());
    }

    public WorldPanel(Collection<Location> locations) {
        super();
        area = ImageUtils.loadWorldImage(W, H);
        setPreferredSize(new Dimension(W, H));
        this.locations = locations;
    }

    public static final int MAX_SIZE = 30;

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(area, 0, 0, null);

        for (Location l : locations) {
            g.setColor(Color.red);
            g.drawOval(l.getX(), l.getY(), size, size);

        }
    }

    public void setWorldLocations(Collection<Location> locations) {
        this.locations.clear();
        
        if (locations != null) {
            this.locations.addAll(locations);
        }
        this.repaint();
    }

    public void setWorldLocation(Location location) {
        this.setWorldLocations(Collections.singleton(location));
    }
    
}
