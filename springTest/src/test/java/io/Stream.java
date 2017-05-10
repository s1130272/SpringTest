package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Stream {

	public static void main(String[] args) {

		File file = new File("ioTest.txt");
		InputStream inputStream = null;

		try {
			if (!file.exists()) {
				file.createNewFile(); // 创建文件
			}
			inputStream = new FileInputStream(file);
			byte [] buf = new byte[1024];  //先写到缓存中，然后再一起写到其他外设中
			int length = 0;
			while ((length=inputStream.read(buf))!=-1){
			    //字节一个一个地读入到内存,需要将int转为字节，如果为中文的话输出乱码字符  ，
				//此处其实是写出到了外设（控制台）上，System.out返回的是PrintStream对象
				System.out.println(new String(buf,0,length));
			}
		} catch (IOException e) {
			e.printStackTrace();  
		}finally {
			if (inputStream != null){  
                try {  
                	inputStream.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
		}

	}

}
