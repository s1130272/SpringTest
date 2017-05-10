package io;

import java.io.File;
import java.io.IOException;

/**
 * @author qinjiayan
 *
 */
public class FileTest {
	
	
	/*public static void main(String[] args) {
		File file = new File("d:/temp", "addfile.txt");  
	    try {  
	        file.createNewFile(); // 创建文件  
	        if  (!file .exists())     
	        {     
	            file .mkdir();   
	        }  
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	}*/
	
	public static void main(String[] args) {
		
		File file1 = new File("d:/temp", "addfile.txt");  
		File dir =new File("d:\\abc");
		File file =new File("d:\\abc\\1.txt");
		try {
			if  (!dir .exists())     
			{     
				dir.mkdirs();
				new File(dir,"2.txt").createNewFile();
			    //file.createNewFile(); // 创建文件  
			}  
		} catch (Exception e) {
			  e.printStackTrace(); 
		}
		
	}

}
