package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Method_Handle_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Method_Handle_info_parser extends Constant_info_parser {
    private byte referenceKind;
    private short referenceIndex;
    protected Constant_Method_Handle_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            readReferenceKind();
            readReferenceIndex();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return new Constant_Method_Handle_info(this.referenceKind, this.referenceIndex);
    }

    private void readReferenceKind() throws IOException {
        this.referenceKind = (byte) this.input.read();
    }
    private void readReferenceIndex() throws IOException {
        this.referenceIndex = ByteUtils.readShort(input);
    }

}
