package be.howest.ti.pokedex.comm;





public class Sum extends Message {
    
    public final int a;
    public final int b;
    
    public Sum(int a, int b){
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void accept(MessageHandler mh){
        mh.handleSum(this);
    }

}
