package org.example.multithreads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CombinedCondition {

    private Lock lock = new ReentrantLock();
    private Condition fullCondition = lock.newCondition();
    private Condition emptyCondition = lock.newCondition();
    private Queue queue = new LinkedList();

    public void populate(String data){
        try{
            lock.lock();
             while (!queue.isEmpty()){
                 emptyCondition.await();
             }
             queue.offer(data);
             fullCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public String getData(){
       String data = null;
        try{
            if (queue.isEmpty()) {
                fullCondition.await();
            }
            data = (String) queue.poll();
            emptyCondition.signalAll();
        }catch(Exception ex){

        }
        return data;
    }

}
