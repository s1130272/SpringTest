package io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {
	
	public static void main(String[] args) throws IOException{
        File demo = new File("Rafdemo"); // 创建一个文件夹
        if(!demo.exists())//如果文件不存在，创建到绝对目录下
             
        {
            demo.mkdirs();//这是个父目录
        }
        File file = new File(demo, "dat.txt");
        if(!file.exists()){
            file.createNewFile();//在demo目录下创建了文件
        }
         
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        //RandomAccessFile raf = new RandomAccessFile("dat.txt", "rw");//读写方式
        //看一下初始时的指针位置
          System.out.println(raf.getFilePointer());
         
        //往里写一个字节后看看指针的位置
           raf.write('A'); //写了一个字节，它的后八位
           //看一下此时的指针位置
           System.out.println(raf.getFilePointer());
          /**
           * 用writechar（）方法时会写入两个字节
           */
           //raf.writeChar('A');
            
           //raf.write()只会写入8bit, 写入一个int要分4步
           int i = 0x7fffffff;//最大的整型
           raf.write(i>>>24);//写进去高八位
           raf.write(i>>>16);
           raf.write(i>>>8);
           raf.write(i); //Java底层的运行机制
           //看一下此时的指针位置
           System.out.println(raf.getFilePointer());
           
           //这一步相当于上面4步， 是raf写入int的封装方法
           raf.writeInt(i);
           
           String s ="中";
           byte[] gbk = s.getBytes("gbk");
           raf.write(gbk);
           System.out.println(raf.length());
            
            
          //读文件,必须把指针移到头部
           raf.seek(0);
           //一次性读取，把文件中的内容都读写到字节数组中
           byte[] buf = new byte[(int)raf.length()];
           raf.read(buf);
            
           System.out.println(Arrays.toString(buf));
           //最后必须关闭
          
           raf.close();
    }

}
