package com.lj.time

import io.netty.buffer.ByteBuf
import io.netty.channel.{ChannelFuture, ChannelFutureListener, ChannelHandlerContext, ChannelInboundHandlerAdapter}

/**
  * TimeServer: server不用收到任何请求, 就会发送一个32bit的整数, 并在发送成功后关闭与客户端的连接
  */
class TimeHandler extends ChannelInboundHandlerAdapter{

  // 连接建立完毕就触发, 再次我们写入一个32bit的整数
  override def channelActive(ctx: ChannelHandlerContext): Unit = {

    val time:ByteBuf = ctx.alloc().buffer(4)
    time.writeInt(Integer.parseInt(System.currentTimeMillis()/1000L+2208988800L+""))

    val f:ChannelFuture = ctx.writeAndFlush(time)
    f.addListener(new ChannelFutureListener {
      override def operationComplete(future: ChannelFuture): Unit = {
        ctx.close()
      }
    })
  }

  override def exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable): Unit = {
    cause.printStackTrace()
    ctx.close()
  }
}
