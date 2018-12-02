//package Semaphores.boundedbuffer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();
        Packet packet = new Packet(5);
        double time = 0;

        // now create the producer and consumer threads
        Thread packetProducer = new Thread(new Producer(server,12, 10));
        Thread packetProducer2 = new Thread(new Producer(server,12, 10));
        Thread firewall = new Thread(new Consumer(server));

        packetProducer.start();
        packetProducer2.start();
        firewall.start();
        time = System.currentTimeMillis();
        //run for 1 minute then move to code below
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("failed");
        }
        time = System.currentTimeMillis() - time;
        packetProducer.stop();
        firewall.stop();
        packet.getAverages();
        //now print averages and maxes
        System.out.println("Wait Times -- Average : " + Packet.avgWaitTime + " Max : " + Packet.maxWaitTime);
        System.out.println("Turnaround Times -- Average : " + Packet.avgTurnaroundTime + " Max : " + Packet.maxTurnaroundTime);
        System.out.println("Service Times -- Average : " + Packet.avgServiceTime + " Max : " + Packet.maxServiceTime);
        System.out.println("Packets Dropped : " + BoundedBuffer.droppedPackets + " out of: " +BoundedBuffer.totalPackets + " == " +(BoundedBuffer.droppedPackets/(BoundedBuffer.totalPackets+BoundedBuffer.droppedPackets))*100 + "%");
        System.out.println("Proccesor Util : " + (Packet.totalServiceTime / time)*100 + "%");
    }
}
