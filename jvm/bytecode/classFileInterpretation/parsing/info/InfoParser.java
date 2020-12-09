package bytecode.classFileInterpretation.parsing.info;

import bytecode.classFileInterpretation.formats.infos.Info;
import bytecode.classFileInterpretation.parsing.FormatParser;

import java.io.BufferedInputStream;
import java.io.InputStream;

public abstract class InfoParser extends FormatParser {

    public InfoParser(InputStream input, Info info) {
        super(input, info);
    }

}
