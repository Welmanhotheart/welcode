package bytecode.classFileInterpretation.attributes;

public class ConstantValue extends Attribute {
    private short constantvalueIndex;

    public ConstantValue(short attributeNameIndex,int attributeLength, short constantvalueIndex ) {
        super(attributeNameIndex,attributeLength);
       this.constantvalueIndex = constantvalueIndex;
    }
}
