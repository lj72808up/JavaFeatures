package com.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCarByLock {
    public static void main(String[] args) throws InterruptedException {
        Car c = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(c));
        executorService.execute(new WaxOff(c));
        Thread.sleep(1000);
        executorService.shutdownNow();
    }
}


class Car{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile boolean waxed = false;

    public void waxed(){
        lock.lock();
        try {   // lock()后紧接try..finally..,让任何情况下都能释放锁
            waxed = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void buffed(){
        lock.lock();
        try{
            waxed = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void wait4Waxing() throws InterruptedException {
        lock.lock();
        try{
            while(!waxed)
                condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void wait4Buffing() throws InterruptedException {
        lock.lock();
        try{
            while(waxed)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
}

class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while(!(Thread.interrupted())){
                System.out.println("Wax on");
                Thread.sleep(200);
                car.waxed();
                car.wait4Buffing();
            }
        } catch (InterruptedException e) {
            System.out.println("wax on interrupted");
        }
        System.out.println("finish wax on");
    }
}

class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while(!(Thread.interrupted())){  // 响应shutdownnow
                System.out.println("Wax off");
                Thread.sleep(200);
                car.wait4Waxing();
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("wax off interrupted");
        }
        System.out.println("finish wax off");
    }
}