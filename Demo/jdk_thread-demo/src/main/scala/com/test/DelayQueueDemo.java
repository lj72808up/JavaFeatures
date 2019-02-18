package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class DelayQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayTask(random.nextInt(5000)));
        }
        queue.put(new DelayTask.EndSentinel(6000,exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}

class DelayedTaskConsumer implements Runnable{
    private DelayQueue<DelayTask> q;  // DelayQueue的take()方法,先获取最紧急的任务
    public DelayedTaskConsumer(DelayQueue<DelayTask> q){
        this.q = q;
    }
    @Override
    public void run() {
        try{
            while(!Thread.interrupted())
                // DelayQueue.take()会阻塞一个延时后返回, 因为obj.getDelay()得到了延时的nano秒数, 在wait(obj.getDelay)后返回
                // q.put()方法, 会把延时短的obj放到队前面. 因为DelayQueue底层是一个PriorityQueue, 延时作为优先级,PriorityQueue的offer方法会上溢
                // 因为DelayQueue需要有优先级, 所以DelayQueue中不能放null对象
                q.take().run(); // run task with the current thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish delayedtaskconsumer!");
    }
}

class DelayTask implements Delayed,Runnable{

    private static int count = 0;
    private int id = count++;
    private final int delta;  // 延时毫秒时间
    private final long trigger;
    protected static List<DelayTask> sequence = new ArrayList<DelayTask>();

    public DelayTask(int delayInMilliseconds){
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta,TimeUnit.MILLISECONDS);
        sequence.add(this);
    }
    @Override
    public void run() {
        System.out.println(this+" ");
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask t = (DelayTask)o;
        if(this.trigger<t.trigger)
            return -1;
        if(this.trigger>t.trigger)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]",delta) + "Task "+id;
    }

    public String summary(){
        return "(" + id +":" +delta + ")";
    }

    public static class EndSentinel extends DelayTask{
        private ExecutorService exec;
        public EndSentinel(int delay,ExecutorService exec) {
            super(delay);
            this.exec = exec;
        }

        @Override
        public void run() {
            for (DelayTask delayTask : sequence) {
                System.out.print(delayTask.summary()+" ");
            }
            System.out.println();
            System.out.println(this + " calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}