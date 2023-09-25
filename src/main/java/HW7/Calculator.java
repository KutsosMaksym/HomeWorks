package HW7;

public class Calculator {
    static int add (int a, int b){
        return a+b;
    }
    static double add (double a, double b){
        return a+b;
    }

    static int subtract (int a, int b){
        return a-b;
    }
    static double subtract (double a, double b){
        return a-b;
    }

    static int multiply (int a, int b){
        return a*b;
    }
    static double multiply (double a, double b) {
        return a*b;
    }

    static int divide (int a, int b) {
        try {
            return a/b;
        }
        catch (NullPointerException e){
            return 0;
        }
    }
    static double divide (double a, double b) {
        try {
            return a/b;
        }
        catch (NullPointerException e){
            return 0;
        }
    }
}
