public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("hehe");
            }
        };
        t.start();
        t.start(); // 不能重复start一个线程, 尤其是已经和运行完毕的线程

        // 1. ExecutorService实现线程重用的语义, 不是通过多次调用线程的start,exec(RUnnable)是将任务提交到队列
        //    而是让new出来的Thread从队列中取任务, 取不到就阻塞, 取到就继续执行
        // 2. newCachedThreadPool - new SynchronousQueue<Runnable>()
        //    newFixedThreadPool - new LinkedBlockingQueue<Runnable>()
        //    newSingleThreadExecutor - new LinkedBlockingQueue<Runnable>()
        // 3. Exector是否产生新线程的逻辑
        //    (1) 如果当前运行的线程少于corePoolSize, 则创建一个新线程来执行任务
        //    (2) 如果当前运行的线程等于或多于corePoolSize, 则将任务插入到阻塞队列
    }
}
