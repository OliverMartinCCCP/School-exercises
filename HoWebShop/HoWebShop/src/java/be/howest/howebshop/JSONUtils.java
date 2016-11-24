package be.howest.howebshop;

import be.howest.howebshop.model.Partim;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JSONUtils {
        public static String toJSONString(Object obj) {
        if (obj instanceof JSONifiable) {
            return toJSONString( (JSONifiable)obj );
        } else if (obj instanceof Collection) {
            return toJSONString( (Collection)obj );
        } else {
            return String.format("\"%s\"", obj.toString());
        }
    }
    
    public static String toJSONString(Map.Entry<String,Object> e){
        return String.format("\"%s\" : %s ",
                e.getKey(),
                toJSONString(e.getValue()));
    }
    
    public static String toJSONString(JSONifiable obj) {
        return obj.toJSONString();
    }
    
    public static String toJSONString(Collection obj) {
        return String.format("[%s]",
                    obj.stream().map(JSONUtils::toJSONString).collect(Collectors.joining(",")));
    }
    
    public static String toJSONString(Object... args) {
        if (args.length==1) {
            return toJSONString(args[0]);
        }
        
        if ((args.length%2)!=0) throw new IllegalArgumentException("toJSONString expects pairs of arguments");
        
        Map<String,Object> kvs = new HashMap<>();
        for (int i=0 ; i< (args.length/2) ; i++){
            kvs.put( (String) args[2*i], args[(2*i)+1]);
        }
        
        String s = kvs.entrySet()
                .stream()
                .map(JSONUtils::toJSONString)
                .collect(Collectors.joining(","));
        
       return String.format("{%s}", s);
        
    }
    
    public static void main(String[] args ){
        System.out.println(JSONUtils.toJSONString("key1","val1","key2","val2"));
        System.out.println(JSONUtils.toJSONString(Arrays.asList("a","b","c")));
        System.out.println(JSONUtils.toJSONString( new Object()));
        System.out.println(JSONUtils.toJSONString( new Partim("Name",3,"C001")));
    }
}