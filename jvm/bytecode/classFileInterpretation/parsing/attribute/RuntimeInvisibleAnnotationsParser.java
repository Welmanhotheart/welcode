package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;

import java.io.InputStream;

public class RuntimeInvisibleAnnotationsParser extends AttributeParser {
    public RuntimeInvisibleAnnotationsParser(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        return null;
    }
}
