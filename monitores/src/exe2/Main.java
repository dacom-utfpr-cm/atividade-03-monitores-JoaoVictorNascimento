/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Escreva um monitor Counter que possibilita um processo dormir
    até o contador alcaçar um valor. A classe Counter permite duas operações: increment() e sleepUntil(int x)
 */
package exe2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CounterMonitor monitor = new CounterMonitor();
        int currentTime = 0;

        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new CounterThread((i*5)+6, monitor, "Thread " + Integer.toString(i)));
            t.start();
        }

        while (currentTime < 26){
            monitor.increment();
            currentTime++;
            System.out.println("Current Time:" + currentTime);
            Thread.sleep(2000);
        }
    }

}
