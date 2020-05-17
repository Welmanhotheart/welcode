package bytecode.classFileInterpretation.formats.infos.constantPool;


import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Class_info extends Constant_info {
    private short index;


    public Constant_Class_info(short index) {
        super(PoolConstantInfoTag.CONSTANT_CLASS_INFO);
        this.index = index;
    }

}
