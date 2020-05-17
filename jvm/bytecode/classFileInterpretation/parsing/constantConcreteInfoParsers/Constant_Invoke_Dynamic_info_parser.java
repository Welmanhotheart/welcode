package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;

import java.io.InputStream;

public class Constant_Invoke_Dynamic_info_parser extends Constant_info_parser {
    protected Constant_Invoke_Dynamic_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        return null;
    }
}
