package be.howest.studentDB;

import be.howest.studentDB.Person;

public class Student extends Person {
    
    private String study;
    private boolean graduated = false;
    
    public Student(String name, String address, String study) {
        super(name, address);
        this.study = study;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" I study %s.", getStudy());
    }

    public String getStudy() {
        return study;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }    
}
