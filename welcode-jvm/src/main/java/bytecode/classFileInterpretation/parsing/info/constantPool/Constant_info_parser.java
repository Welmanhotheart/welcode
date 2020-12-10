package bytecode.classFileInterpretation.parsing.info.constantPool;


import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.InputStream;

public abstract class Constant_info_parser {
    protected InputStream input;
    protected Constant_info_parser(InputStream inputStream) {
        this.input = inputStream;
    }
    public Constant_info parse() {
        return doParse();

    }

    protected  abstract Constant_info doParse();

    public void dispose() {
        this.input = null;
    }
}
