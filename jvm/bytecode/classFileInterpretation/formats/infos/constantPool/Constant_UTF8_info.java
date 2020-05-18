package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_UTF8_info extends Constant_info {
    private short length;
    private  byte[] bytes;
    private String desc;
    public Constant_UTF8_info( short length) {
        super(PoolConstantInfoTag.CONSTANT_UTF8_INFO);
        this.length = length;
    }


    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
