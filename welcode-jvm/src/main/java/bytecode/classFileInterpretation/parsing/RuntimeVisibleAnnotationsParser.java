package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.parsing.attribute.AttributeParser;

import java.io.InputStream;

public class RuntimeVisibleAnnotationsParser extends AttributeParser {
    public RuntimeVisibleAnnotationsParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        return null;
    }
}
