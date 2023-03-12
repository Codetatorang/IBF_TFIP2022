package src;

public class MyRunnableImplementation implements Runnable{
    
    private String task;
    
    public MyRunnableImplementation() {}
    public MyRunnableImplementation(String task) {this.task = task;}

    @Override
    public void run() {
        for(int i =0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + "\t" + task +
            "\tRunnable..." + i);
        }
    }
}
