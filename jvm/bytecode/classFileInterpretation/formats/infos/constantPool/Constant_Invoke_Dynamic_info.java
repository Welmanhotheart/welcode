package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Invoke_Dynamic_info extends Constant_info {
    private short boot_strap_attr_index;
    private short name_type_index;



    protected Constant_Invoke_Dynamic_info(byte tag, short boot_strap_attr_index, short name_type_index) {
        super(PoolConstantInfoTag.CONSTANT_INVOKEDYNAMIC_INFO);
        this.boot_strap_attr_index = boot_strap_attr_index;
        this.name_type_index = name_type_index;

    }

}
