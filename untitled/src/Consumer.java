//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */
import java.util.*;

public class Consumer implements Runnable {

    int sleepTime = 10;
    int proccesingTime = 5;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public Consumer(Buffer b, int pTime, int sTime) {
        buffer = b;
        proccesingTime = pTime;
        sleepTime = sTime;
    }

    public void run() {
        Date message;

        while (true) {
            System.out.println("Consumer napping");
            SleepUtilities.nap();

            // consume an item from the buffer
            System.out.println("Consumer wants to consume.");

            message = (Date) buffer.remove();
            System.out.println("Consumer received message:" + message);
        }
    }
    private Buffer buffer;
}


