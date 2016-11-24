package be.howest.ti.pokedex.comm;





public class Result extends Message  {
    
    public final int res;
    
    public Result(int res){
        this.res = res;
    }
    
    public String toString(){
        return "result is : "+ res;
    }

    @Override
    public void accept(MessageHandler mh) {
        mh.handleResult(this);
    }

}
