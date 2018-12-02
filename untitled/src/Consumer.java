//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Semaphore waitBoi;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        waitBoi = new Semaphore(1);
        Packet packet;

        while (true) {
            packet = (Packet) buffer.remove();
            packet.startRealServiceTime();
            //System.out.println("firewall processing");
            SleepUtilities.nap((int)packet.serviceTime);
            try {
                waitBoi.acquire();
                //System.out.println("P Time: " + packet);
                packet.Stats();
                waitBoi.release();
            } catch (InterruptedException e) {
                System.out.println("waitBoi broke");
                e.printStackTrace();
            }
        }
    }

    private Buffer buffer;
}


