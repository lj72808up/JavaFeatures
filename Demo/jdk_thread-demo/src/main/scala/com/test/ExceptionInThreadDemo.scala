package com.test

import java.util.concurrent.ThreadFactory

/**
  * Thread的run()方法产生的异常,不加处理会直接打印到控制台, 直接在线程.start()外面报上try..catch并不能捕获异常
  * 因此如果有处理线程产生异常的需求, 可使用thread.setUncaughtExceptionHandler(uncaughtExceptionHandler)
  * 给线程绑定异常处理器
  */

class MyUncaughtExeptionHandler extends Thread.UncaughtExceptionHandler{
  override def uncaughtException(t: Thread, e: Throwable): Unit = {
    println(s"caught: ${e}")
  }
}

class ExceptionInThread extends Runnable{
  override def run(): Unit = {
    val t = Thread.currentThread()
    println(s"run() by ${t}")
    println(s"eh: ${t.getUncaughtExceptionHandler}")
  }
}

class HandlerThreadFactory extends ThreadFactory{
  override def newThread(r: Runnable): Thread = {
    val t = new Thread(r)
    println(s"created ${t}")
    t.setUncaughtExceptionHandler(new MyUncaughtExeptionHandler)
    println(s"eh: ${t.getUncaughtExceptionHandler}")
    return t
  }
}

object Main{
  def main(args: Array[String]): Unit = {
    val t = new HandlerThreadFactory().newThread(new ExceptionInThread)
    t.start()
  }
}
