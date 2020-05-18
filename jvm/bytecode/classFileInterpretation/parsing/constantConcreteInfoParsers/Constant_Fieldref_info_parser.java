package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Fieldref_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Fieldref_info_parser extends Constant_info_parser {
    private short cls_info_index;
    private short name_type_index;
    protected Constant_Fieldref_info_parser(InputStream inputStream) {
        super(inputStream);
    }



    protected Constant_info doParse() {

        try {
            readClsInfoIndex();
            readNameTypeIndex();
        } catch (IOException e) {
            //TODO;
            e.printStackTrace();
        }
        return new Constant_Fieldref_info(this.cls_info_index, this.name_type_index);
    }

    private void readClsInfoIndex() throws IOException {
        this.cls_info_index = ByteUtils.readShort(input);
    }

    private void readNameTypeIndex() throws IOException {
        this.name_type_index = ByteUtils.readShort(input);
    }
}
