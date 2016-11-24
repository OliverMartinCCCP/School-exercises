package be.howest.data;

import be.howest.model.Partim;
import be.howest.model.Student;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InMemoryPartimsDA extends PartimsDA {
    
    Set<Partim>  ps = new HashSet<>();
    Set<Student> ss = new HashSet<>();
    
    Map<String,Collection<String>> sn2ps = new HashMap<>();
    
    
    public InMemoryPartimsDA(){
        Student s1 = new Student("Jan","jan123");
        add(s1);
        add(new Student("b","b123"));
        
        Partim p1 = new Partim("P1",1,"CP1");
        add(p1);
        add(new Partim("P2",2,"CP2"));
        add(new Partim("P3",3,"CP3"));
        add(new Partim("P4",4,"CP4"));
        
        add(s1,p1);
        
        
    }

    @Override
    public boolean add(Partim p) {
        return ps.add(p);
    }

    @Override
    public boolean add(Student s) {
        return ss.add(s);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>( ss );
    }

    @Override
    public List<Partim> getPartims() {
        return new ArrayList<>( ps );
    }

    @Override
    public List<Partim> getPartims(Student s) {
        List<Partim> res = new ArrayList<>( );
        for (String code : sn2ps.get(s.getName())){
            Partim p = getPartim(code);
        System.out.println(p);
            if(p!=null)res.add(p);
        }
        return res;
    }

    @Override
    public boolean add(Student s, Partim p) {
        if (sn2ps.get(s.getName()) == null) sn2ps.put(s.getName(),new ArrayList<>());
        sn2ps.get(s.getName()).add(p.getCode());
        return true;
    }

    @Override
    public boolean delete(Student s, Partim p) {
        if (sn2ps.get(s.getName()) == null) return false;
        return sn2ps.get(s.getName()).remove(p.getCode());
    }

    @Override
    public boolean deleteAllPartims(Student s) {
        sn2ps.put(s.getName(),new ArrayList<>());
        return true;
    }

    @Override
    public Student getStudent(String name) {
        for (Student s:ss){
            if (s.getName().equals(name)) return s;
        }
        return null;
    }

    private Partim getPartim(String code) {
        for (Partim p:ps){
            if (p.getCode().equals(code)) return p;
        }
        return null;
    }


}
