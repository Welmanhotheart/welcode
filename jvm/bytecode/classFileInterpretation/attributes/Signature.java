package bytecode.classFileInterpretation.attributes;

public class Signature extends Attribute {
    private short signatureIndex;

    public Signature(short attributeNameIndex,int attributeLength, short signatureIndex ) {
        super(attributeNameIndex,attributeLength);
       this.signatureIndex = signatureIndex;
    }
}
