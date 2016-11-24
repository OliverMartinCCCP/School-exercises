package be.howest.ti.pokedex.comm;





public class Text extends Message {

    public final String txt;

    public Text(String txt){
        this.txt = txt;
    }
    
    @Override
    public String toString(){
        return "MSG: "+txt;
    }
    @Override
    public void accept(MessageHandler mh) {
        mh.handleText(this);
    }
    
}
