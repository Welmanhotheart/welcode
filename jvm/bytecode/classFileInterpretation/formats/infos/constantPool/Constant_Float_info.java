package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.Usize;
import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Float_info extends Constant_Number_info {
    public Constant_Float_info() {
        super(PoolConstantInfoTag.CONSTANT_FLOAT_INFO , Usize.U4);
    }
    
}
