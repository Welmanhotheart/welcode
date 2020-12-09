package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.formats.FieldsCount;
import bytecode.classFileInterpretation.formats.Format;
import bytecode.classFileInterpretation.formats.SingleFormat;

public abstract class Info implements Format {


    private  ClassFormat classFormat;
    private SingleFormat singleItem;
    protected Info(SingleFormat item) {
        this.singleItem = item;
    }

    public Info(FieldsCount item, ClassFormat classFormat) {
        this(item);
        this.classFormat = classFormat;
    }

    public int getSize() {
        return this.singleItem.getValue();
    }

    public ClassFormat getClassFormat() {
        return classFormat;
    }
}
