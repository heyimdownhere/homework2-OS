//package Semaphores.boundedbuffer;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();

        // now create the producer and consumer threads
        Thread packetProducer = new Thread(new Producer(server));
        Thread firewall = new Thread(new Consumer(server));
        try{
            packetProducer.start();
            firewall.start();
        } catch(Exception e) {
            
        }


    }
}
