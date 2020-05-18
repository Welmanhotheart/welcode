package bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Invoke_Dynamic_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Invoke_Dynamic_info_parser extends Constant_info_parser {
    private short boot_strap_attr_index;
    private short name_type_index;
    protected Constant_Invoke_Dynamic_info_parser(InputStream inputStream) {
        super(inputStream);
    }

    protected Constant_info doParse() {
        try {
            readBootStrapSttrIndex();
            readnameTypeIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new Constant_Invoke_Dynamic_info(this.boot_strap_attr_index, this.name_type_index);
    }

    private void readBootStrapSttrIndex() throws IOException {
        this.boot_strap_attr_index = ByteUtils.readShort(input);
    }

    private void readnameTypeIndex() throws IOException {
        this.name_type_index = ByteUtils.readShort(input);
    }

}
