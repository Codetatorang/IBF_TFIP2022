package src;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {
    public void example(){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<10; i++){ //first in last out (FILO) or last in first out(LIFO)
            stack.push(i);
        }

        //pop or taking something out of the stack 
        for(int i = 0; i<5; i++){
            Integer stackItem = stack.pop(); //FIFO or first in first out
            System.out.println("Stack Item (pop): " + stackItem);
        }

        //see what is the last item on top of the stack 
        Integer itm = stack.peek();
        System.out.println("item on top stack: " + itm);

        //get the first element on the stack 
        Integer firstItem = stack.firstElement();
        System.out.println("first element in the stack" + firstItem);

        //search for an item in the stack and reutnr the index where its found on the stack
        Integer idxInteger = stack.search(2);
        System.out.println("Stack element found at index: " + idxInteger);

        //iterating through a stack 
        Iterator<Integer> its = stack.iterator();
        while(its.hasNext()){
            Integer stackIt = its.next();
            System.out.println("Iterator stack items: " + stackIt);
        }
    }
}