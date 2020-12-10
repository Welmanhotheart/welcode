package bytecode.classFileInterpretation.attributes;

public abstract class Attribute {
    protected short attributeNameIndex;
    protected int attributeLength;

    public Attribute() {

    }

    public Attribute(short attributeNameIndex,int attributeLength ) {
        super();
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
    }


    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }
}
