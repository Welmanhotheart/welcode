package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Fieldref_info extends Constant_info {
    private short cls_info_index;
    private short name_type_index;



    public Constant_Fieldref_info(short cls_info_index, short name_type_index) {
        super(PoolConstantInfoTag.CONSTANT_FIELDREF_INFO);
        this.cls_info_index = cls_info_index;
        this.name_type_index = name_type_index;

    }

}
