package array;
import java.util.Random;
import java.lang.Object.*;

public class Array {
    public static void main(String[] args) {
        int[] a = new int[300];
        Random rand = new Random();
        for (int i = 0; i < 300; i++) {
            a[i] = 1 + rand.nextInt(100);
        }
        SumThread sumThread1 = new SumThread(a, 0, 100);
        SumThread sumThread2 = new SumThread(a, 100, 200);
        SumThread sumThread3 = new SumThread(a, 200, 300);
        Thread t1 = new Thread(sumThread1);
        Thread t2 = new Thread(sumThread2);
        Thread t3 = new Thread(sumThread3);
        t1.start();
        t2.start();
        t3.start();
        int s = 0;
        s = sumThread1.getSum() + sumThread2.getSum() + sumThread3.getSum();
        System.out.println(s);
    }
}


class SumThread implements Runnable {
    private SumThrough summer;
    public SumThread(int[] array, int h, int t) {
        summer = new SumThrough(array, h, t);
    }
    public void run() {
        summer.calculateSum();
    }
    public int getSum() {
        return summer.getSum();
    }
}

class SumThrough {
    private int[] numbers;
    private int i = 0, j = 0, s = 0;
    private boolean finished = false;
    public SumThrough(int[] array, int h, int t) {
        i = h; j = t;
        numbers = array;
    }
    public synchronized void calculateSum() {
        for (int t = i; t < j; t++) {
            s += numbers[t];
        }
        finished = true;
        notify();
    }
    public synchronized int getSum() {
        while (!finished)
            try {wait();} catch(Exception e) {}
        return s;
    }

}