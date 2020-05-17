package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.formats.*;
import bytecode.classFileInterpretation.formats.infos.ConstantPoolInfo;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ClassDataParser {
    private ClassFormat classFormat;
    private BufferedInputStream input;

    public ClassDataParser(InputStream inputStream) {
        this.input = new BufferedInputStream(inputStream);
        classFormat = new ClassFormat();
    }

    public ClassFormat parse() {
        try {
            parseMagic();
            parseVersions();
            parseConstantPooolInfo();
            parseAccessFlags();
            parseThisClass();
            parseSuperClass();
            parseInterfaces();
            parseFieldsInfo();
            parseMethodsInfo();
            parseAttributeInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classFormat;
    }

    private void parseMagic() {
        Magic magic = new Magic();
        MagicParser magicParser = new MagicParser(this.input, magic);
        magicParser.parse();
        this.classFormat.setMagic(magic);
    }

    private void parseVersions() {
        parseMinorVersion();
        parseMajorVersion();
    }

    private void parseMinorVersion() {
        MinorVersion minorVersion = new MinorVersion();
        SingleFormatParser parser = new SingleFormatParser(this.input, minorVersion);
        parser.parse();
        this.classFormat.setMinorVersion(minorVersion);
    }
    private void parseMajorVersion() {
        MajorVersion majorVersion = new MajorVersion();
        SingleFormatParser parser = new SingleFormatParser(this.input, majorVersion);
        parser.parse();
        this.classFormat.setMajorVersion(majorVersion);
    }

    private void parseConstantPooolInfo() {
        parseConstantPoolCount();
        parsePoolConstants();
    }

    public void parseConstantPoolCount(){
        ConstantPoolCount constantPoolCount = new ConstantPoolCount();
        SingleFormatParser parser = new SingleFormatParser(this.input, constantPoolCount);
        parser.parse();
        this.classFormat.setConstantPoolCount(constantPoolCount);
    }

    public void parsePoolConstants() {
        ConstantPoolInfo constantPoolInfo = new ConstantPoolInfo(this.classFormat.getConstantPoolCount());
        InfoParser parser = new ConstantPoolInfoParser(this.input, constantPoolInfo);
        parser.parse();
        this.classFormat.setCp_info(constantPoolInfo);

    }

    private void parseAccessFlags() {

    }

    private void parseThisClass() {

    }

    private void parseSuperClass() {

    }

    private void parseInterfaces() {

    }

    private void parseFieldsInfo() {

    }

    private void parseMethodsInfo() {

    }

    private void parseAttributeInfo() {
    }

}
