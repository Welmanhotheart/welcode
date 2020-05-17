package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.InputStream;

public abstract class Constant_info_parser {
    protected InputStream input;
    protected Constant_info constant_info;
    protected Constant_info_parser(InputStream inputStream, Constant_info constant_info) {
        this.input = inputStream;
        this.constant_info = constant_info;
    }
    public Constant_info parse() {
        fillMembers();
        return constant_info;
    }

    protected  abstract void fillMembers();

    public void dispose() {
        this.constant_info = null;
        this.input = null;
    }
}
