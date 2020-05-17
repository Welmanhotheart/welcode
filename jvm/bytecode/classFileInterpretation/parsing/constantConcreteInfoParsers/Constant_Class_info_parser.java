package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Class_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;

import java.io.InputStream;

public class Constant_Class_info_parser extends Constant_info_parser {
    protected Constant_Class_info_parser(InputStream inputStream, Constant_Class_info constant_info) {
        super(inputStream, constant_info);
    }

    protected void fillMembers() {

    }
}
