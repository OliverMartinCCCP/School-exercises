package be.howest.howebshop;

import be.howest.howebshop.model.Partim;
import be.howest.howebshop.model.Student;
import java.util.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtils {
    
    private static final String BASE_DIR = "D:\\Documenten\\SCHOOL\\Howest\\2016 - 2017\\Semester 3\\Java web technology\\HoWebShop\\HoWebShop\\ser\\";
    
    private static ObjectOutputStream createFileOut(String path) throws IOException{
        File f = new File(BASE_DIR+path);
        try {
            f.createNewFile();
            return new ObjectOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(f)));
        }catch (Exception e){
            throw e;
        }
    }
    
    private static ObjectInputStream createFileIn(String path) throws IOException{
        return new ObjectInputStream(
                new BufferedInputStream(
                    new FileInputStream(BASE_DIR+path)));
    }
    
    private static void saveToFile(String path, Object obj){
        try (ObjectOutputStream out = createFileOut(path)) {
            out.writeObject(obj);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Object loadFromFile(String path){
        try (ObjectInputStream in = createFileIn(path)) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void saveToFile(List<Partim> partims){
        saveToFile("partims.ser", partims);
    }
    
    public static List<Partim> loadPartimsFromFile(){
        return (List<Partim>) loadFromFile("partims.ser"); 
    }
    
    private static String studentToFileName(Student s){
        return studentNameToFileName(s.getName());
    }
    private static String studentNameToFileName(String s){
        return String.format("students\\%s.ser", s.replaceAll(" ", "+"));
    }
    
    public static void saveToFile(Student s){
        saveToFile(studentToFileName(s),s);
    }
    
    public static Student loadStudentFromFile(String name){
       System.out.println(studentNameToFileName(name));
        return (Student) loadFromFile(studentNameToFileName(name));
    }
   
    
    
}
