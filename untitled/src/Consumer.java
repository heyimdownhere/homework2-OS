//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */
import java.util.*;

public class Consumer implements Runnable {

    public Consumer(Buffer b) {
        buffer = b;
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


