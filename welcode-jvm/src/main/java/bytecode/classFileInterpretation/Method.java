package bytecode.classFileInterpretation;

public class Method extends ClassMember {
    public Method(short accessFlag, short nameIndex, short descriptorIndex, short attributesCount) {
        super(accessFlag, nameIndex, descriptorIndex, attributesCount);
    }
}
