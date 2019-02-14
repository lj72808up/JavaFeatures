package com.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CancelThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.submit(new Entrance(i));
        }
        Thread.sleep(3*1000);
        Entrance.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("some task were not terminated!");
        System.out.println("Total: "+Entrance.getTotalcount());
        System.out.println("Sum of Entrance: "+Entrance.sumEntrances());
    }
}


class Count{
    private int count = 0;
    private Random r = new Random(1);

    public synchronized int value(){
        return count;
    }

    public synchronized int increment(){
        ++count;
        return count;
    }
}



class Entrance implements Runnable{
    private static Count count = new Count();   // 全局计数
    private static List<Entrance> entrances = new ArrayList<Entrance>();  // 全局维护的入口列表
    private static volatile boolean canceled = false;  // 全局flag, 是否停止进入

    private int number = 0;   // 改入口进入了多少人
    private final int id;

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static int getTotalcount(){
        return count.value();
    }

    public static int sumEntrances(){
        int sum = 0;
        for (Entrance entrance : entrances) {
            sum += entrance.getNumber();
        }
        return sum;
    }

    public static void cancel(){
        // cancel是一个布尔标记, 只会被读取和赋值, 不会与其他域组合在一起被读取, 而赋值是原子操作, 所以不需要同步对其访问, 就可以安全的操作它.
        // 如果你对诸如此事与任何疑虑, 使用Synchronizd
        canceled = true;
    }

    @Override
    public void run() {
        while (!canceled){
            synchronized (this){
                ++number;  // 该入口+1
            }
            System.out.println(this+" Total:"+count.increment());  // 总人数+1
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stoping "+this);
    }

    @Override
    public String toString() {
        return "Entrance "+id+":"+getNumber();
    }

    public synchronized int getNumber(){
        return number;
    }
}