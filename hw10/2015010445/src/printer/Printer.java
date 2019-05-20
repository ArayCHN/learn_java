package printer;

import java.io.*;

public class Printer {
    public static void main(String[] args) {
        printThread1 t1 = new printThread1();
        printThread2 t2_runnable = new printThread2();
        Thread t2 = new Thread(t2_runnable);
        try {
            PrintWriter writer1 = new PrintWriter("print0.txt", "UTF-8");
            t1.setFileWriter(writer1);
            t2_runnable.setFileWriter(writer1);
            t2 = new Thread(t2_runnable);
            t1.start();
            t2.start();
            while (!t1.finished || !t2_runnable.finished) {
                try {Thread.sleep(10);} catch(Exception e) {}
            }
            writer1.close();
        } catch(Exception e) {}

        printThread1 tt1 = new printThread1();
        printThread2 tt2_runnable = new printThread2();
        Thread tt2 = new Thread(tt2_runnable);
        try {
            PrintWriter writer2 = new PrintWriter("print1.txt", "UTF-8");
            tt1.setFileWriter(writer2);
            tt2_runnable.setFileWriter(writer2);
            tt2 = new Thread(tt2_runnable);
            tt2.setPriority(8);
            tt1.start();
            tt2.start();
            while (!tt1.finished || !tt2_runnable.finished) {
                try {Thread.sleep(10);} catch(Exception e) {}
            }
            writer2.close();
        } catch(Exception e) {}
    }
}

class printThread1 extends Thread {
    private PrintWriter writer;
    public boolean finished = false;
    public void setFileWriter(PrintWriter w) {
        writer = w;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread1: " + Integer.toString(i + 1));
            writer.println("Thread1: " + Integer.toString(i + 1));
        }
        finished = true;
    }
}

class printThread2 implements Runnable {
    private PrintWriter writer;
    public boolean finished = false;
    public void setFileWriter(PrintWriter w) {
        writer = w;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread2: " + Integer.toString(i + 1));
            writer.println("Thread2: " + Integer.toString(i + 1));
        }
        finished = true;
    }
}