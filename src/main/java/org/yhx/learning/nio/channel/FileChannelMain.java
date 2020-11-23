package org.yhx.learning.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用buffer+FileChannel 实现文件写入磁盘功能
 * buffer读取数据，然后flip(),最后再被channel写出
 * @author bigmoon
 * @date 2020/11/21
 * @return
 * @see [相关类/方法]（可选）
 * @since 201126
 */
public class FileChannelMain {

    public static void main(String[] args) throws IOException {

        String str="hello nio,感觉有点复杂";
        ByteBuffer byteBuffer= ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes("utf-8"));
        byteBuffer.flip();
        try( FileChannel fileChannel=new FileOutputStream("channleFile.txt").getChannel()) {
            fileChannel.write(byteBuffer);
            System.out.println("fileChannel is over");
        }
    }
}
