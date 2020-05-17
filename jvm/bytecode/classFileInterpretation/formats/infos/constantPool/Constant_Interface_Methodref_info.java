package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Interface_Methodref_info extends Constant_info {
    private short cls_info_index;
    private short name_type_index;



    protected Constant_Interface_Methodref_info(byte tag, short cls_info_index, short name_type_index) {
        super(PoolConstantInfoTag.CONSTANT_INTERFACEMETHODREF_INFO);
        this.cls_info_index = cls_info_index;
        this.name_type_index = name_type_index;

    }

}
