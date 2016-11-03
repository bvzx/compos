package io.bvzx.jdk8.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * Created by bvzx on 16-11-3.
 */
public class Section1 {


    public static final String module="Nio Demo";

    static {
        System.out.println("this is "+module+" , will be initialize");
    }

    public static void main(String [] args) throws IOException {

        long beforeMark=System.currentTimeMillis();
        for (int i =0 ;i<100;i++){

            SeekableByteChannel channel= Files.newByteChannel(new File("/home/bvzx/test.txt").toPath(), StandardOpenOption.READ);

            while (channel.position()<channel.size()){
                ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                channel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array(),"gbk") + i);
            }

            channel.close();

        }

        long afterMark=System.currentTimeMillis();

        System.out.println("---------------------------------wugaoda--------------------------------");

        long transBeforeMark=System.currentTimeMillis();

        for (int i =0; i<100;i++){

            FileInputStream fileInputStream=new FileInputStream(new File("/home/bvzx/test.txt"));

            byte[] buffer=new byte[1024];
            while (fileInputStream.read(buffer)!=-1){
                System.out.println(new String(buffer,"gbk") + i);
            }

            fileInputStream.close();

        }

        long transAfterMark=System.currentTimeMillis();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("begin calculate");
        System.out.println("nio spend time is :" + (afterMark-beforeMark) + "ms");
        System.out.println("tradition spend time is :" + (transAfterMark-transBeforeMark) + "ms");

    }
}
