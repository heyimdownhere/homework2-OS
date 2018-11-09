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
        Packet packet;

        while (true) {
            packet = (Packet) buffer.remove();
            System.out.println("firewall processing");
            SleepUtilities.nap(packet.serviceTime);
            System.out.println("Total packet time in ms:" + packet);
        }
    }
    private Buffer buffer;
}


