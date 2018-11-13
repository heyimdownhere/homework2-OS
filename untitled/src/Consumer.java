//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Consumer implements Runnable {

    //meme name
    public Stats staticor;
    ArrayList<Packet> list;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public Consumer(Buffer b, ArrayList listIN) {
        buffer = b;
        list = listIN;
    }

    public Consumer(Buffer b, Stats stat) {
        buffer = b;
        staticor = stat;
    }

    public void run() {
        Packet packet;

        while (true) {
            packet = (Packet) buffer.remove();
            System.out.println("firewall processing");
            SleepUtilities.nap(packet.serviceTime);
            System.out.println("Total packet time in ms:" + packet);
            AddStats(packet);
        }
    }

    private void AddStats(Packet packet) {
        staticor.addServiceTime(packet.serviceTime);
        staticor.addTurnaroundTime(packet.turnaroundTime);
        staticor.addWaitTimes(packet.waitTime);
    }

    public Stats getStatObj() {
        return staticor;
    }

    private Buffer buffer;
}


