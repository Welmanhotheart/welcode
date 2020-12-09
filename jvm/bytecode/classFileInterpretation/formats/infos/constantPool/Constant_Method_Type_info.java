package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Method_Type_info extends Constant_info {
    private short descriptorIndex;



    public Constant_Method_Type_info( short descriptorIndex) {
        super(PoolConstantInfoTag.CONSTANT_METHODTYPE_INFO);
        this.descriptorIndex = descriptorIndex;

    }

}
