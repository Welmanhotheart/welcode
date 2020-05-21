package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.attributes.Signature;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class SignatureParser extends AttributeParser{
    private short signatureIndex;
    public SignatureParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        try {
            readSignatureIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Signature(this.attributeNameIndex,this.attributeLength, this.signatureIndex);
    }

    private void readSignatureIndex() throws IOException {
        this.signatureIndex = ByteUtils.readShort(this.inputStream);
    }


}
