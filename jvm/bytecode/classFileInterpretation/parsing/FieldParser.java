package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.AttributesCount;
import bytecode.classFileInterpretation.formats.infos.AttributeInfo;
import bytecode.classFileInterpretation.Field;
import bytecode.classFileInterpretation.parsing.info.AttributeInfoParser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;

public class FieldParser {
    private InputStream input;
    private  short accessFlag;
    private  short nameIndex;
    private  short descriptorIndex;
    private  AttributesCount attributesCount;
    private  AttributeInfo attributeInfo;

    public FieldParser(InputStream inputStream) {
        this.input = inputStream;
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


        return new Field(accessFlag, nameIndex, descriptorIndex, attributesCount, attributeInfo);
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

    private void parseAttributesCount() {
        this.attributesCount = new AttributesCount();
        SingleFormatParser parser = new SingleFormatParser(this.input, this.attributesCount);
        parser.parse();

    }
    private void ParseAttributeInfo(){
        this.attributeInfo = new AttributeInfo(this.attributesCount);
        AttributeInfoParser attributeInfoParser = new AttributeInfoParser(this.input, this.attributeInfo);
        attributeInfoParser.parse();
    }


    public void dispose() {
        attributesCount = null;
        attributeInfo = null;
        this.input = null;
    }
}
