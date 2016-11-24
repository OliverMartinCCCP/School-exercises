package be.howest.ti.pokedex.comm;

import java.io.Serializable;







public abstract class Message implements Serializable {

    @Override
    public String toString() {
        return "Message " + this.getClass().getSimpleName();
    }
    
    public abstract void accept(MessageHandler mh);

}
