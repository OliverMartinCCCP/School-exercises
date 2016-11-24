package be.howest.studentDB;

public class Person {
    
    private final String name;
    private final String address;
    
    public Person(String name, String address) {
        this.name   = name;
        this.address = address;
    }
    
    @Override
    public String toString(){
        return String.format("I am %s from %s.", getName(), getAddress());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
}
