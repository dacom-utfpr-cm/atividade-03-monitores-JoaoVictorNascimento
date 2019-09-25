package exe3;

public class IncrementDecrementThread implements Runnable {
    private String state;
    private MonitorBoundedCounter monitor;
    private int delay;

    IncrementDecrementThread(String state, MonitorBoundedCounter monitor, int delay){
        this.state = state;
        this.monitor = monitor;
        this.delay = delay;
    }


    @Override
    public void run(){
        MonitorBoundedCounter monitor;
        try{
            while (true) {
                if(state == "increment"){
                    this.monitor.changeValue("increment");
                } else if(state == "decrement"){
                    this.monitor.changeValue("decrement");
                }
                Thread.sleep(delay);
            }
        } catch (InterruptedException error){
            error.printStackTrace();
        }
    }
}
