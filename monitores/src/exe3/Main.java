package exe3;

public class Main {
    public static void main(String[]args){
        MonitorBoundedCounter monitor = new MonitorBoundedCounter(7, 16);
        Thread thread1 = new Thread(new IncrementDecrementThread("increment", monitor, 500));
        Thread thread2 = new Thread(new IncrementDecrementThread("increment", monitor, 300));
        Thread thread3 = new Thread(new IncrementDecrementThread("decrement", monitor, 1100));

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
