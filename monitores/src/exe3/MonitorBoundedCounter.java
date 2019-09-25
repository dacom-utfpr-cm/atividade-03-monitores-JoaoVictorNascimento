package exe3;

public class MonitorBoundedCounter {
    private int value = 0;
    private int min, max;

    public MonitorBoundedCounter(int min, int max){
        this.min = min;
        this.max = max;
    }

    public synchronized void increment(){
        value++;
        System.out.println("Current Value: " + value);
        while (value >= max) {
            System.out.println("Thread: " + "Maximum Limit Reached...");
            try {
                wait();
            } catch (InterruptedException error) {
               error.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void decrement(){
        value--;
        System.out.println("Current Value: " + value);
        while (value <= min) {
            System.out.println("Thread: " + "Minimum Limit Reached...");
            try {
                wait();
            } catch (InterruptedException error) {
                error.printStackTrace();
            }
        }
        notifyAll();
    }

    public synchronized void changeValue(String state){
        if(state == "increment") {
            increment();
        }
        else if (state == "decrement"){
            decrement();
        }
    }
}
