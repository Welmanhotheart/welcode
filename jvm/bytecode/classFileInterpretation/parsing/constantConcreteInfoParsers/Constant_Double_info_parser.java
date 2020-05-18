package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Double_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Double_info_parser extends Constant_Number_info_parser {
    protected Constant_Double_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        Constant_Double_info double_info = new Constant_Double_info();
        try {
            fillBytes(double_info);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return double_info;
    }
}
