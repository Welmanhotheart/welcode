package util;

import org.junit.Test;

public class MethodTestClass {

    @Test
    public void testMethod() {
        System.out.println(AnalyseClassFileTool.getClassFilePath("class_data.TestClass"));
    }
}
