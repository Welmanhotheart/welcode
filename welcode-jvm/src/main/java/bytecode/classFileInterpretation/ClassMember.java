package bytecode.classFileInterpretation;

import bytecode.classFileInterpretation.attributes.Attribute;

public class ClassMember {
    private final short accessFlag;
    private final short nameIndex;
    private final short descriptorIndex;
    private final short attributesCount;
    private  Attribute[] attributes;

    public ClassMember(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount) {
        this.accessFlag = accessFlag;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;

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

    public short getAttributesCount() {
        return attributesCount;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }
}
