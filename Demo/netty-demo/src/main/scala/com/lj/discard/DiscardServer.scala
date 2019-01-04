package com.lj.discard

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.ByteBuf
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel._


class DiscardServerHandler extends ChannelInboundHandlerAdapter{

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    // 默默丢弃收到的信息
    msg.asInstanceOf[ByteBuf].release()
  }
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    // 发生错误就关闭连接
    cause.printStackTrace()
    ctx.close()
  }
}

object DiscardServer {

  def run():Unit = {
    val bossGroup = new NioEventLoopGroup()
    val workerGroup = new NioEventLoopGroup()

    try{
      val b = new ServerBootstrap()
      b.group(bossGroup,workerGroup)
        .channel(classOf[NioServerSocketChannel])
        .childHandler(new ChannelInitializer[SocketChannel] {
          override def initChannel(ch: SocketChannel): Unit = {
            ch.pipeline().addLast(new DiscardServerHandler())
          }
        })
        .option(ChannelOption.SO_BACKLOG.asInstanceOf[ChannelOption[Any]],128)
        .childOption(ChannelOption.SO_KEEPALIVE.asInstanceOf[ChannelOption[Any]],true)


      val f = b.bind(8111).sync()
      f.channel().closeFuture().sync()
    }finally {
      workerGroup.shutdownGracefully()
      bossGroup.shutdownGracefully()
    }
  }

  def main(args: Array[String]): Unit = {
    DiscardServer.run()
  }
}