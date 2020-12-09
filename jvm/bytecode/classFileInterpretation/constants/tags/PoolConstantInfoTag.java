package bytecode.classFileInterpretation.constants.tags;

/**
 * 常量池中常量项目类型标志
 */
public interface PoolConstantInfoTag {
    byte CONSTANT_UTF8_INFO = 1,
         CONSTANT_INTEGER_INFO = 3,
         CONSTANT_FLOAT_INFO = 4,
         CONSTANT_LONG_INFO = 5,
         CONSTANT_DOUBLE_INFO = 6,
         CONSTANT_CLASS_INFO = 7,
         CONSTANT_STRING_INFO = 8,
         CONSTANT_FIELDREF_INFO = 9,
         CONSTANT_METHODREF_INFO = 10,
         CONSTANT_INTERFACEMETHODREF_INFO = 11,
            CONSTANT_NAMEANDTYPE_INFO = 12,
            CONSTANT_METHODHANDLE_INFO = 15,
            CONSTANT_METHODTYPE_INFO = 16,
            CONSTANT_INVOKEDYNAMIC_INFO = 18;

}
