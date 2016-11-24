package be.howest.model;

import be.howest.data.PartimsDA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private static final int serialVersionUID = 1;
    
    private List<Partim> partims;
    
    public void setPartims(List<Partim> partims){
        this.partims.clear();
        this.partims.addAll(partims);
    }
    
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Student(String name, String password){
        this(name, password, new ArrayList<>());
    }
    
    public Student(String name, String password, List<Partim> partims){
        this.name     = name;
        this.password = password;
        this.partims  = partims;
    }
    
    public void add(Partim p){
        getPartims().add(p);
    }

    public List<Partim> getPartims() {
        if (partims==null) partims = PartimsDA.DB.getPartims(this);
        return partims;
    }

    public boolean takes(Partim p) {
        return getPartims().contains(p);
    }
    
    
}
