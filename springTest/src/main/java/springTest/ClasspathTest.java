package springTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasspathTest {
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Properties props = new Properties();
	    //在src中的dyan/sendhttp包路径下
		//InputStream is = TestSendHttp.class.getClassLoader().getResourceAsStream("dyan/sendhttp/dyan.txt");
	    //在src下
	    InputStream is = MyTestBean.class.getClassLoader().getResourceAsStream("springTest/p.txt");
	    
	    //展示类加载器的父加载器，可以肯定是ExtClassLoader
	    System.out.println(MyTestBean.class.getClassLoader().getParent().toString());
	    //打印user classpath
	    System.out.println(System.getProperty("java.class.path").toString());
	    
	    try 
	    {
	        props.load(is);
            String auther = props.get("author").toString();
	        System.out.println(auther);
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
		
	}
	
	

}
