package bytecode.classFileInterpretation.attributes;

public class LineNumberTable extends Attribute {
    private short lineNumberTableLength;
    private LineNumberInfo[] lineNumberTable;

    static class LineNumberInfo {
        private short startPc;
        private short lineNumber;
    }
}
