package src;

import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public void example(){
        Map<String, Integer> laptops = new ConcurrentHashMap<>();
        laptops.put("Acer", 5);
        laptops.put("Huawei", 11);
        laptops.put("Apple", 9);
        laptops.put("Lenovo", 1);
        laptops.put("Asus", 6);

        // get the total size of the map objects
        System.out.println("Total laptops: " + laptops.size());

        //iterate through the Map (laptops), use keyset method
        for (String key:laptops.keySet()){
            System.out.println(key + "-" + laptops.get(key));
        }

        String searchstring = "Asus";
        if(laptops.containsKey(searchstring)){
            System.out.println(searchstring + "-" + laptops.get(searchstring));
        }

        System.out.println("Enum\n");
        Enumeration<Integer> elems = ((ConcurrentHashMap<String,Integer>) laptops).elements();
        while(elems.hasMoreElements()){
            System.out.println(elems.nextElement());
        }
        Integer retValue = laptops.putIfAbsent("Apple", 25);
        if(retValue!= null){
            System.out.println("Item found with value: " + retValue);
        }

        searchstring = "Apple";
        if(laptops.containsKey(searchstring)){
            System.out.println(searchstring + "-" + retValue);
        }

        laptops.put("microsoft", null);
        for(String key:laptops.keySet()){
            System.out.println(key + "-" + laptops.get(key));
        }
    }
}