package be.howest.studentDB;

/**
 *
 * @author oliver
 */
public class List<T> {
    private T[] array;
    private int freeIdx;
    
    public List(int MAX){
        array = (T[]) new Object[MAX];
        freeIdx= 0;
    }
    
    public void add(T s){
        array[freeIdx] = s;
        freeIdx ++;
    }
    
    public T get(int idx){
        return array[idx];
    }
}
