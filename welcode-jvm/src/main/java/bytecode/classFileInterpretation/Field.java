package bytecode.classFileInterpretation;

public class Field extends ClassMember{

    public Field(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount) {
        super(accessFlag, nameIndex, descriptorIndex, attributesCount);
    }
}
