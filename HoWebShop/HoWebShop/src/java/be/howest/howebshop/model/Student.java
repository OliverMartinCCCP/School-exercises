package be.howest.howebshop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements Serializable {
    private static final int serialVersionUID = 1;
    private final List<Partim> partims;
    
    public Student(String name, String password){
        this(name, password, new ArrayList<Partim>());
    }
    
    public Student(String name, String password, List<Partim> partims){
        super(name, password);
        this.partims = partims;
    }
    
    public void add(Partim p){
        getPartims().add(p);
    }

    public List<Partim> getPartims() {
        return partims;
    }
    
    
}
