package org.example.ringbuffer;

import java.util.concurrent.ConcurrentLinkedDeque;

public class RingBufferFillCount {
    private ConcurrentLinkedDeque<Object> data;

    public Object [] elements = null;
    private int capacity =0;
    private int writePos = 0;
    private int readPos = 0;
    private int available =0;
    public boolean flipped = false;   //the flip marker

    public void reset() {
        this.writePos = 0;
        this.readPos  = 0;
        this.flipped  = false;
    }


    public RingBufferFillCount(int capacity){
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public int getCapacity(){return this.capacity;}

    public int getAvailable(){return this.available;}

    public int remainingCapacity(){
        return capacity - available;
    }

    public boolean put(Object element){
        if (available < capacity) {
            if (writePos >= capacity)
                writePos = 0;
            elements[writePos] = element;
            writePos++;
            available++;
            return true;
        }
        return false;
    }

    public Object take(){
        if (available == 0)
            return null;

        int nextSlot = writePos - available;
        if (nextSlot < 0)
            nextSlot += capacity;
        Object nextObject = elements[nextSlot];
        available--;
        return nextObject;
    }
}
