//package Semaphores.boundedbuffer;

import java.util.ArrayList;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        ArrayList<Packet> list = new ArrayList<Packet>();
        Buffer server = new BoundedBuffer();
        Stats stat = new Stats();

        // now create the producer and consumer threads
        Thread packetProducer = new Thread(new Producer(server,10, 5));
        Thread firewall = new Thread(new Consumer(server, stat));
        try{
            packetProducer.start();
            firewall.start();
        } catch(Exception e) {
            
        }


    }
}
