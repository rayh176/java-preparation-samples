package org.example.design;

public class DiamonProblem {

    public interface Diamon {
        default void print() {};
    }

    public interface Diamon01 extends Diamon {
        default void print(){};
    }

    public interface Diamon02 extends Diamon {
        default void print(){};
    }

    public class DefaultDiamon implements Diamon01, Diamon02 {


        @Override
        public void print() {
            //Solve the diamon problem
            Diamon02.super.print();
        }
    }

    interface A {
        default void foo() { System.out.println("hello from A"); }
    }
    interface B extends A {
        default void foo() { System.out.println("hello from B"); }
    }
    interface C extends A {
        //default void foo() { System.out.println("hello from C"); }
    }

    static class D implements C, B {
       // public void foo() { System.out.println("hello from C"); }
    }

    public static void main(String args []) {
        C c = new D();
        c.foo();
    }
}
