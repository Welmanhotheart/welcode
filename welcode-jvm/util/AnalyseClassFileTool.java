package util;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 类文件分析工具
 */
public class AnalyseClassFileTool {

    /**
     * class文件头魔数占用的字节数
     */
    public static int CLASS_HEAD_LEN = 4;

    public static int MINOR = 2;
    /**
     * 全类名
     */
    private String qualified_class_name;

    private Class cls;


    public AnalyseClassFileTool() {
    }


    public AnalyseClassFileTool(String qualified_class_name) {
        this.qualified_class_name = qualified_class_name;
        initClass();
    }

    /**
     * 初始化类
     */
    private void initClass() {
        try {
            cls = Class.forName(qualified_class_name);
        } catch (Exception e) {
            System.out.println("sorry, error occurs during class initialization");
        }
    }

    /**
     * 获取class文件的路径,读取获得byte
     */
    public void analyse() throws Exception {
        String classFilePath = getClassFilePath(this.qualified_class_name);
        FileInputStream inputStream = new FileInputStream(classFilePath);
        byte [] bytes = new byte[inputStream.available()];
         try {
             inputStream.read(bytes);
             doAnalyse(bytes);
         } finally {
             inputStream.close();
         }
    }

    /**
     *
     * @param bytes
     */
    public void doAnalyse(byte[] bytes) {
        if (this.cls == null) {
            return;
        }

    }

    /**
     * @param qualified_class_name 全类名
     * @return
     */
    public static String getClassFilePath(String qualified_class_name) {
        String classPath = AnalyseClassFileTool.class.getResource("/").getPath();
        if (!StringUtils.isEmpty(qualified_class_name)) {
            return classPath + "" + qualified_class_name.replaceAll("\\.","/") + ".class";
        }
        return null;
    }


}
