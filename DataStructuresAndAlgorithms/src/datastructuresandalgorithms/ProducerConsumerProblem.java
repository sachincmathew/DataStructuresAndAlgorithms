package datastructuresandalgorithms;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {

    public static void main(String args[]) {
        List<Integer> sharedList = new ArrayList<>();
        final int size = 4;
        Thread prodThread = new Thread(new Producer(sharedList, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedList, size), "Consumer");
        prodThread.start();
        consThread.start();
    }
}

class Producer implements Runnable {

    private final List<Integer> sharedList;
    private final int SIZE;

    public Producer(List<Integer> sharedList, int size) {
        this.sharedList = sharedList;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        //wait if queue is full
        while (sharedList.size() == SIZE) {
            synchronized (sharedList) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedList.size());

                sharedList.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedList) {
            sharedList.add(i);
            sharedList.notifyAll();
        }
    }
}

class Consumer implements Runnable {

    private final List<Integer> sharedList;
    private final int SIZE;

    public Consumer(List<Integer> sharedList, int size) {
        this.sharedList = sharedList;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedList.isEmpty()) {
            synchronized (sharedList) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedList.size());
                sharedList.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedList) {
            sharedList.notifyAll();
            return (Integer) sharedList.remove(0);
        }
    }
}