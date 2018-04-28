package exercise.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

import testcase.net.mindview.util.Directory;
import testcase.net.mindview.util.ProcessFiles;


public class Exercise6 {
	public static void main(String[] args) {
//	  new ProcessFiles(new ProcessFiles.Strategy() {
//      public void process(File file) {
//        System.out.println(file);
//      }
//    }, "java").start(args);
		final Date d = new Date(2018, 2, 25);
		ProcessFiles psf = new ProcessFiles(new ProcessFiles.Strategy() {
      public void process(File file) {
        System.out.println(file);
      }
    }, "java"){
			public void processDirectoryTree(File root) throws IOException{
				for(File file : Directory.walk(root, new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						return pathname.lastModified() > d.getTime();
					}
				})){
		      getStrategy().process(file.getCanonicalFile());
				}
			}
		};
		psf.start(args);
	}
}
