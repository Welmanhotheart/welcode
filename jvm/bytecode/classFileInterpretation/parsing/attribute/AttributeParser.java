package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;

import java.io.InputStream;

public abstract class AttributeParser {
    protected short attributeNameIndex;
    protected int attributeLength;
    protected InputStream inputStream;
    protected ClassFormat classFormat;

    public AttributeParser(InputStream input, ClassFormat classFormat) {
        this.inputStream = input;
        this.classFormat = classFormat;

    }
    public Attribute parse() {
        Attribute attribute = doParse();
        dispose();
        return attribute;

    }

    public abstract  Attribute doParse();

    public void dispose() {
        this.inputStream = null;
        this.classFormat = null;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }
}
