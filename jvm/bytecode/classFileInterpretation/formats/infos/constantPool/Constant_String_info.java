package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_String_info extends Constant_info {
    private short index;


    protected Constant_String_info(byte tag, short index) {
        super(PoolConstantInfoTag.CONSTANT_STRING_INFO);
        this.index = index;
    }

}
