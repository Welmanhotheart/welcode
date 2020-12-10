package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.SingleFormat;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;


public class SingleFormatParser extends FormatParser {

    protected byte[] bytes;

    public SingleFormatParser(InputStream inputStream, SingleFormat singleFormat) {
        super(inputStream, singleFormat);
        this.bytes = new byte[this.format.getSize()];
    }

    public void readContent() {
        fillBytes();
        readValue();
    }

    protected void dispose() {
       bytes = null;
       super.dispose();
    }

    private void fillBytes() {
        try {
            int size = this.bytes.length;
            this.inputStream.read(this.bytes, 0, size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readValue() {
        try {
            readValueForSingleFormat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readValueForSingleFormat() throws IOException {
        SingleFormat format = (SingleFormat)this.format;
        format.setValue(ByteUtils.bytes2Int(this.bytes,0, this.bytes.length));
    }


}
