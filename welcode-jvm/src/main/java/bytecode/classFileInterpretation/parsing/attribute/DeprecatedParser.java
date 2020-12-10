package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.attributes.Deprecated;

import java.io.InputStream;

public class DeprecatedParser extends AttributeParser {
    public DeprecatedParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        return new Deprecated(this.attributeNameIndex, this.attributeLength);
    }
}
