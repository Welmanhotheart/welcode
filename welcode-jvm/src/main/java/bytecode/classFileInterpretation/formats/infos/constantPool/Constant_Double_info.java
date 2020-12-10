package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.Usize;
import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Double_info extends Constant_Number_info {
    public Constant_Double_info() {
        super(PoolConstantInfoTag.CONSTANT_DOUBLE_INFO, Usize.U8);
    }
    
}
