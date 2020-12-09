package bytecode.classFileInterpretation;

import bytecode.classFileInterpretation.parsing.ClassDataParser;

import java.io.InputStream;

public class ClassFormatBuilder {

    public ClassFormat build(InputStream inputStream) {
        ClassFormat classFormat = null;
        try {
            ClassDataParser classDataParser = new ClassDataParser(inputStream);
            classFormat = classDataParser.parse();
        } catch (Exception e) {

        }


        return classFormat;
    }

//    public ClassFormat build(String filePath) {
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(filePath);
//            return this.build(inputStream);
//        } catch (Exception e) {
//
//        } finally {
//
//        }
//    }
}
