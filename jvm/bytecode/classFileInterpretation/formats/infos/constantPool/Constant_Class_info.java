package bytecode.classFileInterpretation.formats.infos.constantPool;


import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

public class Constant_Class_info extends Constant_info {

    /**
     * name_index是一个索引值， 它指向常量池中一个CONSTANT_Utf8_info类型常量，
     * 此常量代表了这个类（ 或者接口） 的全限定名， 这里name_index值（ 偏移地址： 0x0000000B）
     * 比如index的值为0x0002， 也即是指向了常量池中的第二项常量。
     */
    private short name_index;


    public Constant_Class_info(short index) {
        super(PoolConstantInfoTag.CONSTANT_CLASS_INFO);
        this.name_index = index;
    }

}
