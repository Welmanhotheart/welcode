package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Integer_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Integer_info_parser extends Constant_Number_info_parser {
    protected Constant_Integer_info_parser(InputStream inputStream) {
        super(inputStream);
    }



    protected Constant_info doParse() {
        Constant_Integer_info integer_info = new Constant_Integer_info();
        try {
            fillBytes(integer_info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integer_info;
    }
}
