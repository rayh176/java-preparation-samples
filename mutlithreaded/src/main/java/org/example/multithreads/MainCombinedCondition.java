package org.example.multithreads;

public class MainCombinedCondition {

    public final static void main(String [] args){
        CombinedCondition combinedCondition = new CombinedCondition();
        new Thread(() -> {for (int i=0; i<20; i++){combinedCondition.populate(String.valueOf(i));}}).start();

    }

}
