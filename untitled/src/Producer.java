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
        System.out.println("Network Recieving packets");

        while (true) {
            // produce an item & enter it into the buffer
            packet = new Packet(proccesingTime);
            buffer.insert(packet);

            SleepUtilities.nap(sleepTime);
        }
    }
    private Buffer buffer;
}
