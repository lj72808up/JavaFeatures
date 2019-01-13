package com.lj.discard

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel._



object DiscardServer {

  def run(handler:ChannelHandler):Unit = {
    // 1. NioEventLoopGroup是一个多线程事件循环处理IO操作. EventLoop实现了不同种类的transport
    //    因为是server端程序, 所以需要两个EventLoop, 一个称为boss, 负责接收客户端连接;里一个叫worker, 负责处理任务逻辑
    //    EventLoop中具体要产生多少个线程,每个线程如何与创建的Channel帮顶起来需要在EventLoop中体现, 可以在constructor中体现
    val bossGroup = new NioEventLoopGroup()
    val workerGroup = new NioEventLoopGroup()

    try{
      // 2. 启动server的帮助类
      val b = new ServerBootstrap()
      b.group(bossGroup,workerGroup)
        // 3. 指定使用NioServerSocketChannel实例化一个channel, 用于接收客户端连接
        .channel(classOf[NioServerSocketChannel])
        // 4. ChannelInitializer用于配置一个channel, 添加一个handler到ChannelPipeline中用于实现网络应用
        .childHandler(new ChannelInitializer[SocketChannel] {
          override def initChannel(ch: SocketChannel): Unit = {
            //ch.pipeline().addLast(new DiscardServerHandler())
            ch.pipeline().addLast(handler)
          }
        })
        // 5. 可以配置channel的tcpip相关参数, 比如tcpNoDelay和keepAlive
        //     option用于配置 NioServerSocketChannel的参数
        .option(ChannelOption.SO_BACKLOG.asInstanceOf[ChannelOption[Any]],128)
        // 6. childOption用于配置接收的 ServerChannel
        .childOption(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Any]],true)


      val f = b.bind(8111).sync()
      f.channel().closeFuture().sync()
    }finally {
      workerGroup.shutdownGracefully()
      bossGroup.shutdownGracefully()
    }
  }

  def main(args: Array[String]): Unit = {

    DiscardServer.run(new EchoServerHandler)
  }
}