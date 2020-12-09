package bytecode.classFileInterpretation;

import bytecode.classFileInterpretation.formats.*;
import bytecode.classFileInterpretation.formats.infos.*;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

public class ClassFormat {
    private Magic magic;
    private MinorVersion minorVersion;
    private MajorVersion majorVersion;
    private ConstantPoolCount constantPoolCount;
    private ConstantPoolInfo cp_info;
    private ClassAccessFlag accessFlag;
    private ThisClass thisClass;
    private SuperClass superClass;
    private InterfacesCount interfacesCount;
    private InterFacesInfo interFacesInfo;
    private FieldsCount fieldsCount;
    private FieldInfo fieldInfo;
    private MethodsCount methodsCount;
    private MethodInfo methodInfo;
    private AttributesCount attributesCount;
    private AttributeInfo attributeInfo;

    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        this.magic = magic;
    }

    public MinorVersion getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(MinorVersion minorVersion) {
        this.minorVersion = minorVersion;
    }

    public MajorVersion getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(MajorVersion majorVersion) {
        this.majorVersion = majorVersion;
    }

    public ConstantPoolCount getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(ConstantPoolCount constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public ConstantPoolInfo getCp_info() {
        return cp_info;
    }

    public Constant_info getCp_info(int index) {
        return cp_info.getConstant_info(index);
    }

    public void setCp_info(ConstantPoolInfo cp_info) {
        this.cp_info = cp_info;
    }

    public ClassAccessFlag getAccessFlag() {
        return accessFlag;
    }

    public void setAccessFlag(ClassAccessFlag accessFlag) {
        this.accessFlag = accessFlag;
    }

    public ThisClass getThisClass() {
        return thisClass;
    }

    public void setThisClass(ThisClass thisClass) {
        this.thisClass = thisClass;
    }

    public SuperClass getSuperClass() {
        return superClass;
    }

    public void setSuperClass(SuperClass superClass) {
        this.superClass = superClass;
    }

    public InterfacesCount getInterfacesCount() {
        return interfacesCount;
    }

    public void setInterfacesCount(InterfacesCount interfacesCount) {
        this.interfacesCount = interfacesCount;
    }

    public InterFacesInfo getInterFacesInfo() {
        return interFacesInfo;
    }

    public void setInterFacesInfo(InterFacesInfo interFacesInfo) {
        this.interFacesInfo = interFacesInfo;
    }

    public FieldsCount getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(FieldsCount fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public FieldInfo getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(FieldInfo fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public MethodsCount getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(MethodsCount methodsCount) {
        this.methodsCount = methodsCount;
    }

    public MethodInfo getMethodInfo() {
        return methodInfo;
    }

    public void setMethodInfo(MethodInfo methodInfo) {
        this.methodInfo = methodInfo;
    }

    public AttributesCount getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(AttributesCount attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo getAttributeInfo() {
        return attributeInfo;
    }

    public void setAttributeInfo(AttributeInfo attributeInfo) {
        this.attributeInfo = attributeInfo;
    }
}
