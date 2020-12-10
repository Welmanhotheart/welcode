package bytecode.classFileInterpretation.formats;

import bytecode.classFileInterpretation.constants.Usize;

public abstract class SingleFormat implements Format {
    static final int size = Usize.U2;
    private int value;
    public  int getSize() {
        return size;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
