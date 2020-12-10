package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.Field;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.parsing.attribute.AttributeParserDelegate;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class FieldParser {
    private InputStream input;
    private ClassFormat classFormat;
    private  short accessFlag;
    private  short nameIndex;
    private  short descriptorIndex;
    private  short attributesCount;
    private Attribute[] attributes;

    public FieldParser(InputStream inputStream, ClassFormat format) {
        this.input = inputStream;
        this.classFormat = format;
    }

    public Field parse() {
        try {
            parseAccessFlag();
            parseNameIndex();
            parseDescriptorIndex();
            parseAttributesCount();
            ParseAttributeInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Field field = new Field(accessFlag, nameIndex, descriptorIndex, attributesCount);
        field.setAttributes(this.attributes);
        return field;
    }

    private void parseAccessFlag() throws IOException {
        accessFlag = ByteUtils.readShort(this.input);
    }


    private void parseNameIndex() throws IOException {
        this.nameIndex = ByteUtils.readShort(this.input);
    }

    private void parseDescriptorIndex() throws IOException {
        this.descriptorIndex = ByteUtils.readShort(this.input);
    }

    private void parseAttributesCount() throws IOException {
        this.attributesCount = ByteUtils.readShort(this.input);

    }
    private void ParseAttributeInfo(){
        this.attributes = new Attribute[this.attributesCount];

        for(int i = 0; i < this.attributesCount; i++) {
            AttributeParserDelegate delegate = new AttributeParserDelegate(this.input, this.classFormat);
            attributes[i] =  delegate.parse();
        }

    }


    public void dispose() {
        this.attributes = null;
        this.input = null;
    }
}
