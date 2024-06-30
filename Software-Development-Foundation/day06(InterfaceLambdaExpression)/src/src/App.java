package src;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class App {

	
	public App() {}

	public static void main(String[] args) {

		//threads with runnable
		Thread thread = new Thread(() -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + "\tRunnable..." + i);
                    }
                });
        thread.start();

		MyRunnableImplementation mRI = new MyRunnableImplementation("Task 1");
		MyRunnableImplementation mRI2 = new MyRunnableImplementation("Task 2");

		ExecutorService singlExecutorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		//single-threading
		singlExecutorService.execute(mRI);
		singlExecutorService.execute(mRI);
		//shutdown executor service
		singlExecutorService.shutdown();

		//multi-threading
		executorService.execute(mRI);
		executorService.execute(mRI2);
		//shutdown executor service
		executorService.shutdown();

		//runnable interface implementations
		MyRunnableInterface<Integer> add = (a,b)-> a + b;
		MyRunnableInterface<Integer> minus = (a,b)-> a - b;
		MyMessageInterface messageString = (a)-> System.out.println(a); 

		//print result
		System.out.println(">> Addition: " + add.process(1, 1));
		System.out.println(">> Subtraction: " + minus.process(1, 1));
		messageString.printMessage("Its time for lunch!");

		List<Employee> employees = new ArrayList<>();
		
		//generate employees
		employees.add(new Employee(1,"Tony", "Stark", 12500));
		employees.add(new Employee(2,"Jack", "Sparrow", 5500));
		employees.add(new Employee(3,"Scarlet", "Rose", 5500));
		employees.add(new Employee(4,"Peter", "Parker", 5500));

		//sort with comparator using foreach lambda
		//sort firstname in reversed order
		Comparator<Employee> compareFirstName = Comparator.comparing(Employee::getFirstName);
		employees.sort(compareFirstName.reversed());

		//print results
		employees.forEach(emp->{System.out.println(emp);});

		//sort group by first name first then last name  
		Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
		employees.sort(groupByComparator);

		//print results
		employees.forEach(emp->{System.out.println(emp);});
	}


	

}
