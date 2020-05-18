package bytecode.classFileInterpretation.parsing.info;

import bytecode.classFileInterpretation.formats.infos.AttributeInfo;

import java.io.InputStream;

public class AttributeInfoParser extends InfoParser {
//    private Attribute
    public AttributeInfoParser(InputStream input, AttributeInfo attributeInfo) {
        super(input, attributeInfo);
    }


    public void readContent() {
        int size = this.format.getSize();
        for(int i = 0; i < size; i++){

        }
    }
}
