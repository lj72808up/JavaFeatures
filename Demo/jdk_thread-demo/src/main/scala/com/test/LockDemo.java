package com.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        AttemptLocking al = new AttemptLocking();

        new Thread(new Runnable() {
            @Override
            public void run() {
                al.timed();
            }
        }).start();
        Thread.yield();  // 让出main线程的执行,给上面的new Thread先执行的机会, 但这并不总有用, jvm线程调度器的实现不同
        al.untimed();
    }
}

class AttemptLocking{

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() throws InterruptedException {
        // try之前获取lock
        boolean captured = lock.tryLock();
        try{
            // try里面写访问共享资源的代码片段, 如果函数有返回值, return自居卸载try里面
            System.out.println(Constant.time()+"trylock(): "+captured);
            Thread.sleep(3000);
        }finally {
            // finally中要释放lock, 这步会在try代码块的返回操作执行之前执行
            if(captured)
                lock.unlock();
        }
    }

    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println(Constant.time()+"lock.tryLock(2, TimeUnit.SECONDS): "+captured);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }finally {
            if (captured)
                lock.unlock();
        }
    }
}