package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_UTF8_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_UTF8_info_parser extends Constant_info_parser {
    private short length;
    private byte[] bytes;
    protected Constant_UTF8_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            readLength();
            readBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Constant_UTF8_info utf8_info = new Constant_UTF8_info(this.length);
        utf8_info.setBytes(this.bytes);
        utf8_info.setDesc(new String(this.bytes));
        return utf8_info;
    }

    private void readLength() throws IOException {
        this.length = ByteUtils.readShort(this.input);
    }

    public void  readBytes() throws IOException {
        bytes = new byte[this.length];
        this.input.read(bytes, 0, this.length);
    }


}
