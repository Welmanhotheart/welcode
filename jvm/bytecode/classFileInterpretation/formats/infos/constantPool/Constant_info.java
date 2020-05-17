package bytecode.classFileInterpretation.formats.infos.constantPool;

/**
 * 常量，
 */
public abstract class Constant_info {
    private final byte tag;

    protected Constant_info(byte tag) {
        this.tag = tag;
    }

    public byte getTag() {
        return tag;
    }

}
