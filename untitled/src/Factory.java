//package Semaphores.boundedbuffer;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();

        // now create the producer and consumer threads
        Thread producerThread = new Thread(new Producer(server));
        Thread producer2 = new Thread(new Producer(server));
        Thread consumerThread1 = new Thread(new Consumer(server));
        Thread consumerThread2 = new Thread(new Consumer(server));
        producerThread.start();
        producer2.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
