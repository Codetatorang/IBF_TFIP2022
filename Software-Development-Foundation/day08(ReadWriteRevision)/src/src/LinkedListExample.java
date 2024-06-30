package src;

import java.util.LinkedList;

//this is a linkedlist example
public class LinkedListExample {
    public void example(){
        LinkedList<String> ll = new LinkedList<>();
        ll.add("A");
        ll.add("B");
        ll.add("C");
        ll.add("D");
        ll.add("E");
        ll.add("F");
        ll.add("G");

        // ll.forEach(i->System.out.println(i));
        System.out.println(ll);
        ll.remove("C");

        System.out.println(ll);
        
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);
    }
}