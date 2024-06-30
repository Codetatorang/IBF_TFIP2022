package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionSortExample {
    public void example(){
        List<Integer> numbers = new ArrayList<>();

        for(int i =0; i<10; i++){
            numbers.add((int) (Math.random() * 100));
        }
        //print out unsorted list
        System.out.print("Unsorted list: " + numbers);

        //sort in ascending
        Collections.sort(numbers);
        Object[] arrayNum = numbers.toArray();
        Arrays.sort(arrayNum);

        //print out the sorted list
        System.out.println("Sorted list: " + numbers);

        numbers.sort(Comparator.reverseOrder());
        //print out the sorted list in reversed order
        System.out.println("Sorted list: " + numbers);
    }

    public void example2(){
        Employee emp1 = new Employee(12345, "Dionne", "SS", "Advisor", "test1@gmail.com",20000);
        Employee emp2 = new Employee(12345, "Gionne", "SS", "Advisor", "test2@gmail.com",10000);
        Employee emp3 = new Employee(12345, "Fionne", "SS", "Advisor", "test3@gmail.com",15000);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        //print out employees list beofre sorting
        System.out.println("unsorted employees" + employees);

        //do an ascending sort using collections
        Collections.sort(employees);

        //print out sorted employees list
        System.out.println("sort by collections: ");
        System.out.println(employees);

        //sorting using comparator and lambda
        System.out.println("sort by comparator: ");
        employees.sort(Comparator.comparing(e->e.getSalary()));

        System.out.println("Sorted employees salary: " + employees);

        List<Employee> filteredEmployees =  employees.stream().filter(e->e.getFullName().equalsIgnoreCase("Fionne")).collect(Collectors.toList());
        System.out.println("Filtered employees: "+ filteredEmployees);

    }
}