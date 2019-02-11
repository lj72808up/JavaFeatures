package com.test


class Sleeper(name:String) extends Thread(name){
  override def run():Unit = {
    try{
      Thread.sleep(5*1000)
    }catch{
      case ex:InterruptedException => 
        println(s"${Constant.time()} ${this.getName} was interupted,isInterrupted() in catch: ${this.isInterrupted}")
      case _ =>
    }
    println(s"${Constant.time()} ${this.getName} has awakened")
  }
}

class Joiner(sleeper:Sleeper,name:String) extends Thread(name){
  override def run(): Unit ={
    try{
      sleeper.join()
    }catch{
      case ex:InterruptedException =>
        println(s"${Constant.time()} ${this.getName} was interupted,isINterrupted() in catch: ${this.isInterrupted}")
      case _ =>
    }
    println(s"${Constant.time()} ${this.getName} join completed")
  }
}

/**
  * Sleeper和Joiner是两个Thread类.
  *   - Sleeper中调用sleep()方法, sleep()方法有可能在指定时间期满后返回, 但也可能被中断. 因此sleep()方法要在try..catch内响应中断异常
  *     sleep()方法是native方法, 当另一个线程调用sleeper想成的interupt()方法时, 将给这个线程设置一个'中断标记'标志, 表明该线程已被中断. 但
  *     当异常被catch捕获之后, 会清理这个标志, 所以catch块内调用this.isInterrupted()方法时, 这个标记总返回false
  *
  *   - Joiner线程通过调用sleeper线程的join()方法, 等待sleeper醒来并执行结束. Main函数里, 每个Sleeper都偶遇一个Joiner, 可以在输出中发现, 无论
  *     Sleeper正常结束还是响应中断而结束, joiner线程都会和sleeper线程一起结束
  *
  *   - JDK中提供的CyclicBarrier, 比最初线程类库中提供的join()方法更加易用
  */

object Test {
  def main(args: Array[String]): Unit = {
    val sleepy = new Sleeper("Sleepy")
    val grumpy = new Sleeper("Grumpy")

    val dopey = new Joiner(sleepy,"Dopey")
    val doc = new Joiner(grumpy,"Doc")

    sleepy.start()
    grumpy.start() // sleeper
    dopey.start()  // joiner
    doc.start()

    grumpy.interrupt()  // 中断grumpy线程
  }
}