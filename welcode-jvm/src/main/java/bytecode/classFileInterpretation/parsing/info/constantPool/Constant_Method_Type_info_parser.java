package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Method_Type_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Method_Type_info_parser extends Constant_info_parser {
    private short descriptorIndex;
    protected Constant_Method_Type_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            readDescriptorIndex();
        } catch (IOException e) {
            //TODO
            e.printStackTrace();
        }
        return new Constant_Method_Type_info(this.descriptorIndex);
    }

    private void readDescriptorIndex() throws IOException {
        this.descriptorIndex = ByteUtils.readShort(this.input);
    }
}
