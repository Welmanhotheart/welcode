package bytecode.classFileInterpretation.parsing.info.constantPool;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_Class_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class Constant_Class_info_parser extends Constant_info_parser {
    private short name_index;
    protected Constant_Class_info_parser(InputStream inputStream) {
        super(inputStream);
    }


    /**
     *
     * @return
     */
    protected Constant_info doParse() {

        try {
            readNameIndex();
        } catch (IOException e) {
            //todo,这里要做异常处理
            e.printStackTrace();
        }
        return new Constant_Class_info(this.name_index);
    }

    /**
     * 读取nameindex
     * @throws IOException
     */
    private void readNameIndex() throws IOException {
        this.name_index = ByteUtils.readShort(this.input);
    }
}
