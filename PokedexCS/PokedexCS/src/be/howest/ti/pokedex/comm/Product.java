package be.howest.ti.pokedex.comm;





public class Product extends Message {

    public final int a;
    public final int b;
    
    public Product (int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void accept(MessageHandler mh) {
        mh.handleProduct(this);
    }

    
}
