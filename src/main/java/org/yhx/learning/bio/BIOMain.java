package org.yhx.learning.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author bigmoon
 * @date 2020/11/21
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class BIOMain {

    public static void main(String[] args) throws IOException {

        Executor executor= Executors.newFixedThreadPool(3);
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("服务启动");

        while (true){

            Socket socket=serverSocket.accept();
            System.out.println("已经监听到一个内容");
            executor.execute(()->{
            try( InputStream inputStream=socket.getInputStream()){

                byte[] buffer=new byte[1024];
                int readIndex;

                while((readIndex=inputStream.read(buffer))!=-1){
                    System.out.println("接受内容:"+new String(buffer,0,readIndex));
                }
            }catch(Exception ex){
            }
            });
        }
    }
}
