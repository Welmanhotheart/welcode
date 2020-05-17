package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.SingleFormat;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;


public class SingleFormatParser {
    protected InputStream inputStream;
    protected SingleFormat singleFormat;
    protected byte[] bytes;

    public SingleFormatParser(InputStream inputStream, SingleFormat singleFormat) {
        this.inputStream = inputStream;
        this.singleFormat = singleFormat;
        this.bytes = new byte[this.singleFormat.getSize()];
    }

    public void parse() {
       readValue();
       dispose();
    }

    private void dispose() {
        bytes = null;
        this.inputStream = null;
        this.singleFormat = null;
    }

    public void readValue() {
        try {
            int size = this.bytes.length;
            this.inputStream.read(this.bytes, 0, size);
            readValueForSingleFormat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readValueForSingleFormat() throws IOException {
        singleFormat.setValue(ByteUtils.bytes2Int(this.bytes,0, this.bytes.length));
    }
}
