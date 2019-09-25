package exe2;

public class CounterMonitor {
    private int counterValue;

    public synchronized void increment() {
        ++ this.counterValue;
        notifyAll();
    }

    public synchronized void sleepUntil(int counter) throws InterruptedException{
        try {
            while (this.counterValue < counter ) {
                wait();
            }
        }
        catch (InterruptedException error){
            error.printStackTrace();
        }

    }
}
