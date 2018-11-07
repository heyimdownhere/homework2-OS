//package Semaphores.boundedbuffer;

/**
 * This is the producer thread for the bounded buffer problem.
 */
import java.util.*;

public class Producer implements Runnable {
    int sleepTime = 10;
    int proccesingTime = 5;

    public Producer(Buffer b) {
        buffer = b;
    }

    public Producer(Buffer b, int pTime, int sTime) {
        buffer = b;
        proccesingTime = pTime;
        sleepTime = sTime;
    }
    public void run() {
        Packet packet;

        while (true) {
            System.out.println("Producer napping");
            SleepUtilities.nap();

            // produce an item & enter it into the buffer
            packet = new Packet(proccesingTime);
            System.out.println("Producer produced " + packet);

            buffer.insert(packet);
        }
    }
    private Buffer buffer;
}
