package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.infos.Info;

import java.io.BufferedInputStream;

public abstract class InfoParser extends FormatParser{

    public InfoParser(BufferedInputStream input, Info info) {
        super(input, info);
    }

}
