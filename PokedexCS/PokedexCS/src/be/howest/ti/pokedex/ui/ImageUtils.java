package be.howest.ti.pokedex.ui;

import be.howest.ti.pokedex.model.Pokemon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
    
    public final static int WOLRD_WIDTH = 600; 
    public final static int WOLRD_HEIGHT = 400;
    
    public static Image loadPokemonImage(Pokemon pokemon, int size) {
        String fileName = "";
        if (pokemon == null) {
            fileName ="resources/ball.png";
        } else {
            fileName += pokemon.getId();
            
            if (pokemon.getId() < 100) {
                fileName = "0" + fileName;
            }
            if (pokemon.getId() < 10) {
                fileName = "0" + fileName;
            }

            fileName = String.format("resources/gif/%s.gif", fileName);

        }
        
        return loadImage(fileName,size,size);
    }
    
    private static Image loadImage(String relPath, int w, int h){
        try {
            return ImageIO.read(new File(relPath)).getScaledInstance(w, h, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            ex.printStackTrace();
            // Create dummy image: 
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            img.getGraphics().drawString("dummy for:"+relPath, 0, h/2);
            return img;
        }
    }

    static Image loadWorldImage(int w, int h) {
       return loadImage("resources/world.png",w, h);
    }

}
