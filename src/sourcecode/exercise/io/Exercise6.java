package exercise.io;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

import net.mindview.util.Directory;
import net.mindview.util.ProcessFiles;


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
        }, "class");
        psf.start(new String[]{"D:\\maven_repository\\org\\mybatis\\mybatis\\3.4.1\\mybatis-3.4.1\\org\\apache\\ibatis"});
    }
}
