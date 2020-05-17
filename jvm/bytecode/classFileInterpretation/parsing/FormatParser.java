package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.Format;

import java.io.InputStream;

public abstract class FormatParser {
    protected InputStream inputStream;
    protected Format format;
    public FormatParser(InputStream inputStream, Format format) {
        this.inputStream = inputStream;
        this.format = format;
    }
    protected void dispose() {
        this.inputStream = null;
        this.format = null;
    }

    public void parse() {
        readContent();
        dispose();
    }
    public abstract void readContent();
}
