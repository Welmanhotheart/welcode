package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Name_Type_info extends Constant_info {
    private short aindex;
    private short bindex;



    protected Constant_Name_Type_info(byte tag, short aindex, short bindex) {
        super(PoolConstantInfoTag.CONSTANT_NAMEANDTYPE_INFO);
        this.aindex = aindex;
        this.bindex = bindex;

    }

}
