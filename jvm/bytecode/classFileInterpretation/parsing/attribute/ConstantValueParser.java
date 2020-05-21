package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.attributes.ConstantValue;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class ConstantValueParser extends AttributeParser {

    private short constantvalueIndex;

    public ConstantValueParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        try {
            readConstantvalueIndex();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ConstantValue(this.attributeNameIndex,
                this.attributeLength,  this.constantvalueIndex);

    }

    private void  readConstantvalueIndex() throws IOException {
        this.constantvalueIndex = ByteUtils.readShort(this.inputStream);
    }
}
