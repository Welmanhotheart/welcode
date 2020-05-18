package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Float_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Float_info_parser extends Constant_Number_info_parser {
    protected Constant_Float_info_parser(InputStream inputStream) {
        super(inputStream);
    }


    protected Constant_info doParse() {
        Constant_Float_info float_info = new Constant_Float_info();
        try {
            fillBytes(float_info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return float_info;
    }
}
