package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.Usize;
import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Integer_info extends Constant_Number_info {
    protected Constant_Integer_info(byte tag) {
        super(PoolConstantInfoTag.CONSTANT_INTEGER_INFO, Usize.U4);
    }
    
}
