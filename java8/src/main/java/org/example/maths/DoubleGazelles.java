package org.example.maths;

public class DoubleGazelles {

    private static final double VALUE_NAN = Double.NaN;

    public static double divide(double value){
        return value/0;
    }

    public static double addToMaxValue() {
        return Double.MAX_VALUE + 1;
    }

    public static double addToMinValue() {
        return Double.MIN_VALUE - 1;
    }

    public static int addIntToMaxValue() {
        return Integer.MAX_VALUE + 1;
    }

    public static int addIntToMinValue() {
        return Integer.MIN_VALUE - 1;
    }

    public static void main(String args []) {
        System.out.println("Divide by ZERO return " + divide(5));

        System.out.println("MAX value " + Double.MAX_VALUE);
        System.out.println("More then MAX return " + addToMaxValue());
        System.out.println("MIN value " + Double.MIN_VALUE);
        System.out.println("Less then MIN return " + addToMinValue());

        System.out.println("MAX INT value " + Integer.MAX_VALUE);
        System.out.println("More then MAX INT return " + addIntToMaxValue());
        System.out.println("MIN INT value " + Integer.MIN_VALUE);
        System.out.println("Less then MIN INT return " + addIntToMinValue());
    }
}
