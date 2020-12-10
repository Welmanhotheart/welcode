package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Method_Handle_info extends Constant_info {
    private byte referenceKind;
    private short referenceIndex;



    public Constant_Method_Handle_info(byte referenceKind, short referenceIndex) {
        super(PoolConstantInfoTag.CONSTANT_METHODHANDLE_INFO);
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;

    }

}