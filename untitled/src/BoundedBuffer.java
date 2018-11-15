//package Semaphores.boundedbuffer;

import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer.java
 *
 * This program implements the bounded buffer with semaphores.
 * Note that the use of count only serves to output whether
 * the buffer is empty of full.
 */
public class BoundedBuffer implements Buffer {

    private static final int BUFFER_SIZE = 2;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
    private int count;
    private int in, out;
    private Object[] buffer;
    public static int droppedPackets;
    public static int totalPackets;

    public BoundedBuffer() {
        // buffer is initially empty
        count = 0;
        in = 0;
        out = 0;

        buffer = new Object[BUFFER_SIZE];

        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);
    }

    public BoundedBuffer(int bufferSize) {
        // buffer is initially empty
        count = 0;
        in = 0;
        out = 0;

        buffer = new Object[bufferSize];

        mutex = new Semaphore(1);
        empty = new Semaphore(bufferSize);
        full = new Semaphore(0);
    }

    // producer calls this method
    public void insert(Object item) {
        //used to drop packets if the buffer is full
        if(count == BUFFER_SIZE) {
            System.out.println("PACKET DROPPED -- BECAUSE BUFFER FULL");
            droppedPackets++;
            return;
        }
        //System.out.println("shouldnt print after packet dropped");

        try {
            empty.acquire();
            mutex.acquire();
        } catch (Exception e) {
        }
        // add an item to the buffer
        ++count;
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;

        if (count == BUFFER_SIZE) {
            System.out.println("            Packet received --- Buffer FULL");
        } else {
            System.out.println("            Packet received --- Buffer Size = " + count);
        }
        totalPackets++;
        mutex.release();
        full.release();
    }

    // consumer calls this method
    public Object remove() {
        try {
            full.acquire();
            mutex.acquire();
        } catch (Exception e) {
        }

        // remove an item from the buffer
        --count;
        Object item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;

        if (count == 0) {
            System.out.println("            Firewall took packet --- Buffer EMPTY");
        } else {
            System.out.println("            Firewall took packet --- Buffer Size = " + count);
        }

        mutex.release();
        empty.release();

        return item;
    }
}
