package bytecode.classFileInterpretation.attributes;

public class Exceptions extends Attribute {
    private short numberOfExceptions;
    private short[] exceptionIndexes;

    public short getNumberOfExceptions() {
        return numberOfExceptions;
    }

    public void setNumberOfExceptions(short numberOfExceptions) {
        this.numberOfExceptions = numberOfExceptions;
    }

    public short[] getExceptionIndexes() {
        return exceptionIndexes;
    }

    public void setExceptionIndexes(short[] exceptionIndexes) {
        this.exceptionIndexes = exceptionIndexes;
    }
}
