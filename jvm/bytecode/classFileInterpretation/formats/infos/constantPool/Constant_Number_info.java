package bytecode.classFileInterpretation.formats.infos.constantPool;

public abstract class Constant_Number_info extends Constant_info {

    private byte bytes[];
    protected Constant_Number_info(byte tag, int byteCount) {
        super(tag);
        this.bytes = new byte[byteCount];
    }

    public byte[] getBytes() {
        return bytes;
    }
}
