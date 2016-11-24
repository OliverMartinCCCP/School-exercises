package be.howest.howebshop.model;

import be.howest.howebshop.JSONifiable;
import be.howest.howebshop.FileUtils;
import be.howest.howebshop.JSONUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partim implements JSONifiable, Serializable {
    private static final int serialVersionUID = 1;
    public static final List<Partim> PARTIMS;;
    
    static {
        List<Partim> temp = FileUtils.loadPartimsFromFile();
        if (temp==null || temp.isEmpty()){
            System.out.println("Making my own partims");
            PARTIMS = new ArrayList<>();
            PARTIMS.add( new Partim("Java Web Technology" , 3 , "C01") );
PARTIMS.add( new Partim("Advanced JavaScript" , 2 , "C02") );
PARTIMS.add( new Partim("Business Solutions and Digital Marketing" , 2 , "C03") );
PARTIMS.add( new Partim("User Experience Design" , 2 , "C04") );

PARTIMS.add( new Partim("Information Modeling" , 2 , "C10") );
PARTIMS.add( new Partim("Advanced SQL" , 2 , "C11") );
PARTIMS.add( new Partim("Webservices and Information Exchange" , 2 , "C12") );

PARTIMS.add( new Partim("Server Operating Systems Concepts" , 3 , "C20") );
PARTIMS.add( new Partim("Windows Server Lab" , 3 , "C21") );
PARTIMS.add( new Partim("Linux Server Lab" , 3 , "C22") );

PARTIMS.add( new Partim("Advanced Server Web" , 2 , "C30") );
PARTIMS.add( new Partim("Mobile Web Apps" , 3 , "C31") );
PARTIMS.add( new Partim("Native Mobile Apps" , 2 , "C32") );
PARTIMS.add( new Partim("Smart Devices" , 2 , "C33") );
            FileUtils.saveToFile(PARTIMS);
        } else {
            PARTIMS = temp;
        }
    }
    
    private final String name;
    private final int    sp;
    private final String code;
    
    public Partim(String name, int sp, String code) {
        this.name = name;
        this.sp = sp;
        this.code = code;
    }

    @Override
    public String toJSONString() {
        return JSONUtils.toJSONString("msg","NYI");
    }

    public String getName() {
        return name;
    }

    public int getSp() {
        return sp;
    }

    public String getCode() {
        return code;
    }
    
}
