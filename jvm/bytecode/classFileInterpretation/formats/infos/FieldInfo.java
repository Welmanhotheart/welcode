package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.Field;
import bytecode.classFileInterpretation.formats.FieldsCount;

public class FieldInfo extends Info {

    private Field[] fields;
    public FieldInfo(FieldsCount item) {
        super(item);
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }
}
