package src;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public void example() {
        Map<String, Integer> phones = new HashMap<>();

        //key value pair using put
        phones.put("iPhone", 10);
        phones.put("Samsung", 1);
        phones.put("Oppo", 50);
        phones.put("Huawei", 20);

        System.out.println("Total phone types: " + phones.size());

        for (String key : phones.keySet()) {
            System.out.println(key + "-" + phones.get(key));
        }
        Console cons = System.console();
        String searchString = "";
        
        while (!searchString.equals("quit")) {
            searchString = cons.readLine("Enter searchString: ");
            if (phones.containsKey(searchString)) {
                System.out.println(searchString + "-" + phones.get(searchString));
              
            }else{
                continue;
            }
        }
    }
}