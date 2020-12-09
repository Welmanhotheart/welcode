package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.attributes.Deprecated;
import bytecode.classFileInterpretation.attributes.Synthetic;

import java.io.InputStream;

public class SyntheticParser extends AttributeParser {
    public SyntheticParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        return new Synthetic(this.attributeNameIndex, this.attributeLength);
    }
}
