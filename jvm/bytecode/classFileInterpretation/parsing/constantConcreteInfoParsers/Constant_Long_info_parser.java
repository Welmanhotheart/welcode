package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Long_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Long_info_parser extends Constant_Number_info_parser {
    protected Constant_Long_info_parser(InputStream inputStream) {
        super(inputStream);
    }


    protected Constant_info doParse() {
        Constant_Long_info constant_long_info = new Constant_Long_info();
        try {
            fillBytes(constant_long_info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return constant_long_info;
    }
}
