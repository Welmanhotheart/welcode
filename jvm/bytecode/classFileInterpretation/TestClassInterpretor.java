package bytecode.classFileInterpretation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestClassInterpretor {
    public static void main(String[] args) throws FileNotFoundException {
        ClassFormatBuilder builder = new ClassFormatBuilder();
        FileInputStream in = new FileInputStream("D:\\learnjavaworkspace\\welcode\\BoxingTest.class");
        ClassFormat classFormat = builder.build(in);
        System.out.println("succeed");
    }
}
