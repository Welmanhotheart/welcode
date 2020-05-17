package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.formats.Format;
import bytecode.classFileInterpretation.formats.SingleFormat;

public abstract class Info implements Format {
    private SingleFormat singleItem;

    protected Info(SingleFormat item) {
        this.singleItem = item;
    }
    public int getSize() {
        return this.singleItem.getValue();
    }
}
