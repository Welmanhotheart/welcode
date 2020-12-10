package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Number_info;

import java.io.IOException;
import java.io.InputStream;

public abstract class Constant_Number_info_parser extends Constant_info_parser{
    public Constant_Number_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected void fillBytes(Constant_Number_info info) throws IOException {
        byte[] bytes = info.getBytes();
        int length = bytes.length;
        this.input.read(bytes, 0, length);
    }
}
