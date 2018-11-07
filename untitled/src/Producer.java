//package Semaphores.boundedbuffer;

/**
 * This is the producer thread for the bounded buffer problem.
 */
import java.util.*;

public class Producer implements Runnable {

    public Producer(Buffer b) {
        buffer = b;
    }

    public void run() {
        Date message;

        while (true) {
            System.out.println("Producer napping");
            SleepUtilities.nap();

            // produce an item & enter it into the buffer
            message = new Date();
            System.out.println("Producer produced " + message);

            buffer.insert(message);
        }
    }
    private Buffer buffer;
}
