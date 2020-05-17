package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Method_Type_info extends Constant_info {
    private short descriptorIndex;



    protected Constant_Method_Type_info(byte tag, short descriptorIndex) {
        super(PoolConstantInfoTag.CONSTANT_METHODTYPE_INFO);
        this.descriptorIndex = descriptorIndex;

    }

}
