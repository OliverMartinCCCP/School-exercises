package be.howest.data;

import be.howest.model.Partim;
import be.howest.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLPartimsDA extends PartimsDA {

    private static final String URL = "jdbc:mysql://localhost:3306/howest";
    private static final String USR = "root";
    private static final String PSW = "root";
    
    private static final String SQL_ADD_PARTIM           = "INSERT INTO partim(idpartim,name,sp) values (?,?,?);";
    private static final String SQL_ADD_STUDENT          = "INSERT INTO student(name,password) values (?,?);";
    private static final String SQL_GET_STUDENTS         = "SELECT * FROM student;";
    private static final String SQL_GET_STUDENT          = "SELECT * FROM student WHERE name = ?";
    private static final String SQL_GET_PARTIMS          = "SELECT * FROM partim;";
    private static final String SQL_GET_PARTIMS_STUDENT  = "SELECT partim.idpartim , partim.name, partim.sp FROM student_partims JOIN partim ON partim=idpartim JOIN student on student=idstudent WHERE student.name = ?;";
    private static final String SQL_ADD_PARTIM_STUDENT   = "INSERT INTO student_partims(student,partim) SELECT student.idstudent , ? FROM student WHERE student.name = ?";
    private static final String SQL_DEL_PARTIM_STUDENT   = "DELETE student_partims FROM student_partims JOIN student ON student.idstudent = student_partims.student WHERE student_partims.partim = ? AND student.name = ?";
    private static final String SQL_DEL_PARTIMS_STUDENT  = "DELETE student_partims FROM student_partims JOIN student ON student.idstudent = student_partims.student WHERE student.name = ?";

    

    Connection conn;

    protected MySQLPartimsDA() {
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USR, PSW);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean add(Partim p) {

        try  {
            PreparedStatement stmt = conn.prepareStatement(SQL_ADD_PARTIM);
            stmt.setString(1, p.getCode());
            stmt.setString(2, p.getName());
            stmt.setInt(3, p.getSp());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean add(Student s) {

        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_ADD_STUDENT);
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getPassword());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Student> getStudents() {
        try {
            Statement stmt = conn.createStatement() ;
            ResultSet rs = stmt.executeQuery(SQL_GET_STUDENTS);
            List<Student> ss = new ArrayList<>();
            
            while( rs.next() ) {
                ss.add(new Student(rs.getString("name"), rs.getString("password"),null));
            }
            
            rs.close();
            stmt.close();
            
            return ss;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Partim> _getPartims() {
        try  {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_GET_PARTIMS);
            
            List<Partim> ps = new ArrayList<>();
            
            while( rs.next() ) {
                ps.add(new Partim(rs.getString("name"), rs.getInt("sp"), rs.getString("idpartim")));
            }
            
            rs.close();
            stmt.close();
            
            return ps;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private List<Partim> partims = null;
    public List<Partim> getPartims() {
        if (partims==null) partims = _getPartims();
        return partims;
    }
    
    public List<Partim> getPartims(Student s) {
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_GET_PARTIMS_STUDENT);
            stmt.setString(1, s.getName());
            ResultSet rs = stmt.executeQuery();
            
            List<Partim> ps = new ArrayList<>();
            while( rs.next()){
                ps.add(new Partim(rs.getString("name"), rs.getInt("sp"), rs.getString("idpartim")));
            }
            
            rs.close();
            stmt.close();
            
            return ps;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }
    
    public boolean add(Student s, Partim p) {
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_ADD_PARTIM_STUDENT);
            stmt.setString(1, p.getCode());
            stmt.setString(2, s.getName());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean delete(Student s, Partim p) {
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_DEL_PARTIM_STUDENT);
            stmt.setString(1, p.getCode());
            stmt.setString(2, s.getName());
            stmt.close();
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean deleteAllPartims(Student s) {
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_DEL_PARTIMS_STUDENT);
            stmt.setString(1, s.getName());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Student getStudent(String name) {
        try {
            PreparedStatement stmt = conn.prepareStatement(SQL_GET_STUDENT);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            Student s = null;
            if ( rs.next() ){
                s = new Student(rs.getString("name"), rs.getString("password"),null);
            }
            rs.close();
            stmt.close();
            return s;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
    }

    public void addPartims(Student student, String[] codes) {
        for(String code : codes){
            add(student,new Partim(null,-1,code));
        }
    }
    
}
