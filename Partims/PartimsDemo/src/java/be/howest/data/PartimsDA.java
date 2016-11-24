package be.howest.data;

import be.howest.model.Partim;
import be.howest.model.Student;
import java.util.Collection;
import java.util.List;

public abstract class PartimsDA {
    
    public static final PartimsDA DB = new InMemoryPartimsDA();
    
        public void add(Collection<Partim> c) {
        for (Partim e : c) {
            add(e);
        }
    }

    public abstract boolean add(Partim p);
    
    public abstract boolean add(Student s);
    
    public abstract List<Student> getStudents();

    public abstract List<Partim> getPartims();
    
    public abstract List<Partim> getPartims(Student s);
    
    public abstract boolean add(Student s, Partim p);
    
    public abstract boolean delete(Student s, Partim p);
    
    public abstract boolean deleteAllPartims(Student s);
    
    public abstract Student getStudent(String name);

    public void addPartims(Student student, String[] codes) {
        for(String code : codes){
            add(student,new Partim(null,-1,code));
        }
    }
    
    public static void main(String[] args) {
        for(Partim p : DB.getPartims()) {
            System.out.println(p.getName());
        }
    }
    
}
