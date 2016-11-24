package be.howest.ti.pokedex.comm;





public interface MessageHandler {

    public void handleResult(Result r);
    
    public void handleProduct(Product p);
    
    public void handleSum(Sum s);
    
    public void handleText(Text t);
    

}
