package bytecode.classFileInterpretation.attributes;

public class LocalVariableTable extends Attribute {
    private short localVariableTableLength;
    private  LocalVariableInfo[] localVariableTable;

    static class LocalVariableInfo{
        private short startPc;
        private short length;
        private short nameIndex;
        private short descriptorIndex;
        private short index;

    }

}
