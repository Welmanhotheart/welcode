package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.Usize;
import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Float_info extends Constant_Number_info {
    protected Constant_Float_info(byte tag) {
        super(PoolConstantInfoTag.CONSTANT_FLOAT_INFO , Usize.U4);
    }
    
}
