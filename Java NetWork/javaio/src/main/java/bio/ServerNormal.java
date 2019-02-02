package com.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public final class ServerNormal {

    private static int port = 12345;
    private static ServerSocket server;
    //线程池内部包含队列,会把连接成功,待处理的socket及处理方法(new ServerHandler(socket))放到队列中
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) throws IOException{
        try{
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            //通过无限循环监听客户端连接
            while(true){
                // accept()方法一直阻塞,直到有连接建立成功
                Socket socket = server.accept();
                executorService.execute(new ServerHandler(socket));
                // 非线程池版本为: new Thread(new ServerHandler(socket)).start();
            }
        }finally{
            //一些必要的清理工作
            if(server != null){
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
            }
        }
    }
}
