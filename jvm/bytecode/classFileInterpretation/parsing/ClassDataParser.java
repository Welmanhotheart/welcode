package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.formats.*;
import bytecode.classFileInterpretation.formats.infos.ConstantPoolInfo;
import bytecode.classFileInterpretation.formats.infos.FieldInfo;
import bytecode.classFileInterpretation.formats.infos.InterFacesInfo;
import bytecode.classFileInterpretation.parsing.info.ConstantPoolInfoParser;
import bytecode.classFileInterpretation.parsing.info.FieldInfoParser;
import bytecode.classFileInterpretation.parsing.info.InfoParser;
import bytecode.classFileInterpretation.parsing.info.InterFacesInfoParser;

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
        ClassAccessFlag flag = new ClassAccessFlag();
        SingleFormatParser parser = new SingleFormatParser(this.input, flag);
        parser.parse();
        this.classFormat.setAccessFlag(flag);
    }

    private void parseThisClass() {
        ThisClass cls = new ThisClass();
        SingleFormatParser parser = new SingleFormatParser(this.input, cls);
        parser.parse();
        this.classFormat.setThisClass(cls);
    }

    private void parseSuperClass() {
        SuperClass spcls = new SuperClass();
        SingleFormatParser parser = new SingleFormatParser(this.input, spcls);
        parser.parse();
        this.classFormat.setSuperClass(spcls);

    }

    private void parseInterfaces() {
        parseInterfacesCount();
        parseInterfaceInfo();

    }

    private void parseInterfacesCount() {
        InterfacesCount interfacesCount = new InterfacesCount();
        SingleFormatParser parser = new SingleFormatParser(this.input, interfacesCount);
        parser.parse();
        this.classFormat.setInterfacesCount(interfacesCount);
    }

    private void parseInterfaceInfo() {
        InterFacesInfo interFacesInfo = new InterFacesInfo(this.classFormat.getInterfacesCount());
        InterFacesInfoParser parse = new InterFacesInfoParser(this.input, interFacesInfo);
        parse.parse();
        this.classFormat.setInterFacesInfo(interFacesInfo);
    }

    private void parseFieldsInfo() {
        parseFieldsCount();
        parseFields();
    }


    private void parseFieldsCount() {
        FieldsCount fieldsCount = new FieldsCount();
        SingleFormatParser parser = new SingleFormatParser(this.input, fieldsCount);
        parser.parse();
        this.classFormat.setFieldsCount(fieldsCount);

    }
    private void parseFields() {
        FieldInfo fieldInfo = new FieldInfo(this.classFormat.getFieldsCount());
        FieldInfoParser parser = new FieldInfoParser(this.input, fieldInfo);
        parser.parse();
        this.classFormat.setFieldInfo(fieldInfo);
    }




    private void parseMethodsInfo() {

    }

    private void parseAttributeInfo() {
    }

}
