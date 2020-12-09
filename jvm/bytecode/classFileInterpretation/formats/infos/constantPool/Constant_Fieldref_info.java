package bytecode.classFileInterpretation.formats.infos.constantPool;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Fieldref_info extends Constant_info {
    /**
     * 指向声明字段的类或者接口描述符Constant_Class_info的索引项
     */
    private short cls_info_index;

    /**
     * 指向字段描述符Constant_NameAndType的索引项
     */
    private short name_type_index;



    public Constant_Fieldref_info(short cls_info_index, short name_type_index) {
        super(PoolConstantInfoTag.CONSTANT_FIELDREF_INFO);
        this.cls_info_index = cls_info_index;
        this.name_type_index = name_type_index;

    }

}
