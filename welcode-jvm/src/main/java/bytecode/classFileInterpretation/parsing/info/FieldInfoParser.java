package bytecode.classFileInterpretation.parsing.info;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.Field;
import bytecode.classFileInterpretation.formats.infos.FieldInfo;
import bytecode.classFileInterpretation.formats.infos.Info;
import bytecode.classFileInterpretation.parsing.FieldParser;

import java.io.BufferedInputStream;

public class FieldInfoParser extends InfoParser {
    private Field[] fields;
    public FieldInfoParser(BufferedInputStream input, FieldInfo fieldInfo) {
        super(input, fieldInfo);
    }

    public void readContent() {
        this.fields = new Field[this.format.getSize()];
        int fieldsCount = this.fields.length;
        ClassFormat classFormat = ((Info) this.format).getClassFormat();
        for(int i = 0; i < fieldsCount; i++) {
            FieldParser parser = new FieldParser(this.inputStream, classFormat);
            this.fields[i] = parser.parse();
            parser.dispose();
        }

        FieldInfo fieldInfo = (FieldInfo) this.format;
        fieldInfo.setFields(fields);
    }

    protected void dispose() {
        this.fields = null;
        super.dispose();
    }
}
