package be.howest.ti.pokedex;

import be.howest.ti.pokedex.data.TrainerDA;
import be.howest.ti.pokedex.model.PokedexApp;
import be.howest.ti.pokedex.model.Trainer;
import be.howest.ti.pokedex.ui.PokedexFrame;
import javax.swing.SwingUtilities;

public class StartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Init Model
        Trainer trainer = TrainerDA.instance.loadTrainer();
        if (trainer == null) {
            trainer = new Trainer("Ash");
        }
        PokedexApp app = new PokedexApp(trainer);

        // Init GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PokedexFrame frame = new PokedexFrame(app);
                frame.setVisible(true);
            }
        });

    }
}
