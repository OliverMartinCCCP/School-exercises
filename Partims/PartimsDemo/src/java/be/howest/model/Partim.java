package be.howest.model;

import java.io.Serializable;
import java.util.Objects;

public class Partim implements Serializable {
    private static final int serialVersionUID = 1;

    private final String name;
    private final int    sp;
    private final String code;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partim other = (Partim) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    public Partim(String name, int sp, String code) {
        this.name = name;
        this.sp = sp;
        this.code = code;
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
