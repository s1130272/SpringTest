package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
	
	// main入参 args 可传入过滤条件
	public static void main(String[] args) {
		
		File path = new File(".");
		String[] FileNamelist;
		
		if(args.length==0){
			FileNamelist = path.list();
		}else{
			FileNamelist =  path.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
				
			});
		}
		Arrays.sort(FileNamelist,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : FileNamelist){
			System.out.println(dirItem);
		}
		
	}
	
} 