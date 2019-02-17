package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new HorseRace(nHorse,pause);
    }
}

class HorseRace{
    private static final int FINISH_LINE = 40;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses,final int pause){
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    builder.append("=");
                }
                System.out.println(builder);
                for (Horse hors : horses) {
                    System.out.println(hors.tracks());
                }
                for (Horse hors : horses) {
                    if(hors.getStrides()>FINISH_LINE){
                        System.out.println(hors + "won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try{
                    Thread.sleep(pause);
                }catch (InterruptedException e){
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }

    }
}

class Horse implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private int strides = 0;  //步幅
    private static Random rand = new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier b){
        barrier = b;
    }

    public synchronized int getStrides(){
        return strides;
    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (InterruptedException e) {
            // 因中断的退出是合法退出
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
            // 需要知道是什么错误
        }
    }

    @Override
    public String toString() {
        return "Horse "+id+" ";
    }

    public String tracks(){
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<this.getStrides(); i++){
            builder.append("*");
        }
        builder.append(id);
        return builder.toString();
    }
}