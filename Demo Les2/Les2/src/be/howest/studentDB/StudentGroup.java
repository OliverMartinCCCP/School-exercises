package be.howest.studentDB;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    
    private Lector    titularis;
    private final List students;

    public StudentGroup() {
        this.students = new ArrayList();
    }
    
    @Override
    public String toString(){
        return String.format("Class group with %s students ()",
                students.size() ,
                getTitularis().getName());
    }
    
    public void add(Student student) {
        students.add(student);
    }
    
    public List getStudents() {
        return students;
    }

    public Lector getTitularis() {
        return titularis;
    }

    public void setTitularis(Lector titularis) {
        this.titularis = titularis;
    }
}
