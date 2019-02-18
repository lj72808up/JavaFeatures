package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// SynchronousQueue用于实现线程能之间传递一个共享变量, 之所以继承queue是为了使用put和take方法
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                try {
                    Integer i = queue.take();
                    System.out.println("get " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        exec.execute(producer);
        exec.execute(consumer);

    }

    /**
     * 使用Lock实现Synchronous相同的功能, 代码量很大
     * @param args
     * @throws InterruptedException
     */
    public static void main1(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicInteger sharedState = new AtomicInteger();
        Item item = new Item();

        exec.execute(new Setter(1,item));
        exec.execute(new Setter(2,item));
        exec.execute(new Setter(3,item));

        exec.execute(new Getter(item));
        exec.execute(new Getter(item));
        exec.execute(new Getter(item));

        System.out.println(item.get());
    }
}

class Item{
    private volatile boolean flag = false;
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    public int get() throws InterruptedException {
        lock.lock();
        try{
            while(!flag)
                full.await();
            flag = false;
            empty.signalAll();
            return this.num;
        } finally {
            lock.unlock();
        }
    }

    public void set(int number) {
        lock.lock();
        try{
            while(flag)
                empty.await();
            this.num = number;
            flag = true;
            full.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Setter implements Runnable{
    private int number;
    private Item item;

    public Setter(int number, Item item) {
        this.number = number;
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println(item + " set "+number);
        item.set(number);
    }
}

class Getter implements Runnable{
    private Item item;

    public Getter(Item item) {
        this.item = item;
    }

    @Override
    public void run() {
        int c = 0;
        try {
            c = item.get();
            System.out.println("get "+c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}