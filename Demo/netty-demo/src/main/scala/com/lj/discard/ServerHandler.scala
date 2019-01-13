package com.lj.discard

import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter}
import io.netty.util.CharsetUtil

/**
  * 1. 忽略一切信息的server
  */
class DiscardServerHandler extends ChannelInboundHandlerAdapter{

  // 收到消息时被调用
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    // 默默丢弃收到的信息
    // 此处认为接收到的信息是ByteBuf. ByteBuf是ReferenceCounted的子类, 所有ReferenceCounted的对象使用后都要释放(release方法)
    msg.asInstanceOf[ByteBuf].release()
  }
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    // 发生错误就关闭连接
    // netty的IO异常,handler程序的处理异常都会触发这个事件.
    // 多数情况下,发生的异常应该在这里被记录log,并且把分配到的channel关闭,关闭channel前应该发送一个包含错误码的response
    cause.printStackTrace()
    ctx.close()
  }
}

/**
  * 2. 打印received message的server
  */
class PrintServerHandler extends ChannelInboundHandlerAdapter{

  // 收到消息时被调用
  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    val info = msg.asInstanceOf[ByteBuf]
    println(s"receive:${info.toString(CharsetUtil.US_ASCII)}")
  }
  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    cause.printStackTrace()
    ctx.close()
  }

  override def channelInactive(ctx: ChannelHandlerContext): Unit = {
    println("链接关闭")
  }
}

/**
  * 3. 实现ECHO协议的server: any received data is sent back.
  */
class EchoServerHandler extends ChannelInboundHandlerAdapter{

  override def channelRead(ctx: ChannelHandlerContext, msg: Any): Unit = {
    ctx.write(msg) // 此处, 我们并没有像DiscardServer一样, 把收到的msg[ByteBuf]释放掉,因为netty会自动释放msg[ByteBuf]当信息已被写出后
    ctx.flush()
  }
}