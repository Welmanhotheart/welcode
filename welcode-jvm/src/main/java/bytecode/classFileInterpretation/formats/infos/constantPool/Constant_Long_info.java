package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.Usize;
import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Long_info extends Constant_Number_info {
    public Constant_Long_info() {
        super(PoolConstantInfoTag.CONSTANT_LONG_INFO, Usize.U8);
    }
    
}