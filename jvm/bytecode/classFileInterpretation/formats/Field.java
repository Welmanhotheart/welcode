package bytecode.classFileInterpretation.formats;

import bytecode.classFileInterpretation.formats.AttributesCount;
import bytecode.classFileInterpretation.formats.infos.AttributeInfo;

public class Field {
    private final short accessFlag;
    private final short nameIndex;
    private final short descriptorIndex;
    private final AttributesCount attributesCount;
    private final AttributeInfo attributeInfo;

    public Field(short accessFlag, short nameIndex, short descriptorIndex, AttributesCount attributesCount, AttributeInfo attributeInfo) {
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.attributeInfo = attributeInfo;
    }


    public short getAccessFlag() {
        return accessFlag;
    }


    public short getNameIndex() {
        return nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }


    public AttributeInfo getAttributeInfo() {
        return attributeInfo;
    }


    public AttributesCount getAttributesCount() {
        return attributesCount;
    }

}
