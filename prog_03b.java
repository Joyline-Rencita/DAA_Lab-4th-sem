3b.  Write a Java program that implements a multi-thread application that has three threads. First thread generates a random integer for every 1 second; second thread computes the square of the number and prints; 
third thread will print the value of cube of the number

package multithread;
import java.util.Random;

class Square implements Runnable {
    public int x;

    public Square(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("From Second Thread - Square of " + x + " is: " + x * x);
    }
}

class Cube implements Runnable {
    public int x;

    public Cube(int x) {
        this.x = x;
    }

    public void run() {
        System.out.println("From Third Thread - Cube of " + x + " is: " + x * x * x);
    }
}

class FirstThreadIsRandom extends Thread {
    public void run() {
        int num;
        Random r = new Random();
        
        try {
            for (int i = 0; i < 5; i++) {
                num = r.nextInt(100);
                System.out.println("First Thread Started and Generated Number is " + num);
                Thread t2 = new Thread(new Square(num));
                t2.start();
                Thread t3 = new Thread(new Cube(num));
                t3.start();
                Thread.sleep(1000);
                System.out.println("------------------------------------------------------");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        FirstThreadIsRandom firstThread = new FirstThreadIsRandom();
        Thread t1 = new Thread(firstThread);
        t1.start();
    }
}
