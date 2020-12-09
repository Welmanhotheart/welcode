package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Methodref_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Methodref_info_parser extends Constant_info_parser {
    private short cls_info_index;
    private short name_type_index;
    protected Constant_Methodref_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            readClsInfoIndex();
            readNameTypeIndex();
        } catch (IOException e) {
           //TODO
            e.printStackTrace();
        }
        return new Constant_Methodref_info(this.cls_info_index, this.name_type_index);
    }

    private void readClsInfoIndex() throws IOException {
        this.cls_info_index = ByteUtils.readShort(this.input);
    }

    private void readNameTypeIndex() throws IOException {
        this.name_type_index = ByteUtils.readShort(this.input);
    }


}
