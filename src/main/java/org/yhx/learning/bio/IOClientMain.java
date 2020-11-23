package org.yhx.learning.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author bigmoon
 * @date 2020/11/21
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class IOClientMain {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",6666);
        System.out.println("启动客户端");
        socket.getOutputStream().write("abcde".getBytes());
        socket.close();
    }
}
