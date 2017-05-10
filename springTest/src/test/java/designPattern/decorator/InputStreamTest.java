package designPattern.decorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("Rafdemo/dat.txt");
			LowerCaseInputStream lis = new LowerCaseInputStream(fis);
			int c;
			while((c=lis.read())!=-1){
				System.out.println((char)(c));
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
