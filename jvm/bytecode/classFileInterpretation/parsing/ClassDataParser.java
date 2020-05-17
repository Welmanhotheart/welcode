package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.formats.Magic;
import bytecode.classFileInterpretation.formats.MajorVersion;
import bytecode.classFileInterpretation.formats.MinorVersion;
import bytecode.classFileInterpretation.formats.SingleFormat;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class ClassDataParser {
    private ClassFormat classFormat;
    private BufferedInputStream inputStream;

    public ClassDataParser(InputStream inputStream) {
        inputStream = new BufferedInputStream(inputStream);
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
            //TODO
        }
        return classFormat;
    }

    private void parseMagic() {
        Magic magic = new Magic();
        MagicParser magicParser = new MagicParser(this.inputStream, magic);
        magicParser.parse();
        this.classFormat.setMagic(magic);
    }

    private void parseVersions() {
        parseMinorVersion();
        parseMajorVersion();
    }

    private void parseMinorVersion() {
        MinorVersion minorVersion = new MinorVersion();
        SingleFormatParser parser = new SingleFormatParser(this.inputStream, minorVersion);
        parser.parse();
        this.classFormat.setMinorVersion(minorVersion);
    }
    private void parseMajorVersion() {
        MajorVersion majorVersion = new MajorVersion();
        SingleFormatParser parser = new SingleFormatParser(this.inputStream, majorVersion);
        parser.parse();
        this.classFormat.setMajorVersion(majorVersion);
    }

    private void parseConstantPooolInfo() {

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
