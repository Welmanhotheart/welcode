package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_UTF8_info extends Constant_info {
    private short length;
    private byte[] bytes;

    protected Constant_UTF8_info(byte tag, short length) {
        super(PoolConstantInfoTag.CONSTANT_UTF8_INFO);
        this.length = length;
    }

}
