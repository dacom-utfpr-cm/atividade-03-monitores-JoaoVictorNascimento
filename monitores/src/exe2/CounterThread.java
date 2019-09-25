package exe2;

public class CounterThread implements Runnable {

    private final CounterMonitor monitor;
    private int awaken;
    private String name;

    CounterThread(int awaken, CounterMonitor monitor, String name){
        this.awaken = awaken;
        this.monitor = monitor;
        this.name = name;
    }
    


    @Override
    public void run(){
        try {
            monitor.sleepUntil(this.awaken);
        }
        catch (InterruptedException error) {
            error.printStackTrace();
        }
        System.out.println(name + " " + "Awakened in: " + this.awaken);
    }
}
