//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Consumer implements Runnable {

    ArrayList<Packet> list;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public Consumer(Buffer b, ArrayList listIN) {
        buffer = b;
        list = listIN;
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


