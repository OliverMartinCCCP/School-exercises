package be.howest.ti.pokedex.data;

import be.howest.ti.pokedex.PokedexException;
import be.howest.ti.pokedex.model.Trainer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TrainerDA {

    public final static String TRAINER_FILE = "trainer.pojo";
    public final static TrainerDA instance = new TrainerDA();

    public void save(Trainer trainer) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(TRAINER_FILE)
            );
            oos.writeObject(trainer);
            oos.close();
        } catch (IOException ex) {
            throw new PokedexException("Cannot write trainer to file.", ex);
        }
    }

    public Trainer loadTrainer() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(TRAINER_FILE)
            );
            Trainer t = (Trainer) ois.readObject();
            return t;
        } catch (IOException ex) {
            throw new PokedexException("Cannot read trainer file file.", ex);
        } catch (ClassNotFoundException ex) {
            throw new PokedexException("Cannot read trainer file file.", ex);
        }
    }

}
