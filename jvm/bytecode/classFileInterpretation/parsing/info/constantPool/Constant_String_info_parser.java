package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_String_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_String_info_parser extends Constant_info_parser {
    private short index;
    protected Constant_String_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            this.index = ByteUtils.readShort(this.input);
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return new Constant_String_info(this.index);
    }
}
