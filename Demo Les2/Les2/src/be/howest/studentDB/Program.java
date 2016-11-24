package be.howest.studentDB;

import be.howest.studentDB.Lector;
import be.howest.studentDB.Student;
import be.howest.studentDB.StudentGroup;

public class Program {
    private static final int MAX = 30;

    public static void main(String[] args) {

        List<Student> students = new List<Student>(MAX);
        List<Lector>  lectors  = new List<Lector>(MAX);
        
        
        
        Lector v = new Lector("Frédéric Vlummens", "Belgium");
        
        Student s1 = new Student("Joske Vermeulen", "Belgium", "TI");
        Student s2 = new Student("Els De Meester", "Belgium", "TI");
        Student s3 = new Student("William Williamson", "Canada", "TI");
        
        Pair<Lector, Student> pair = new Pair<>(v, s1);
        
        List<Pair<Lector, Student>> lectorsStudenten = new List<Pair<Lector, Student>>(MAX);
        lectorsStudenten.add(pair);

        
        StudentGroup g1 = new StudentGroup();
        g1.setTitularis(v);
        g1.add(s1);
        g1.add(s2);
        g1.add(s3);
        
        Lector m = new Lector("Mattias De Wael", "Belgium");
        
        Student s4 = new Student("Tom De Keesstekker", "Belgium", "OM");
        Student s5 = new Student("Franne Du Chat", "France", "OM");
        Student s6 = new Student("Benjamin Verminnen", "Belgium", "OM");
        
        StudentGroup g2 = new StudentGroup();
        g2.setTitularis(m);
        g2.add(s4);
        g2.add(s5);
        g2.add(s6);
        
        System.out.println(g1.getTitularis());
        for (Object o : g2.getStudents() ) {
           System.out.println( o );
        }
        
        System.out.println(lectorsStudenten.get(0).getFirst());
        // g2.getStudents().stream().forEach( System.out::println );
        
        
    }
    
}
