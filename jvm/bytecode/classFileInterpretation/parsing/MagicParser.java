package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.Magic;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.BufferedInputStream;

public class MagicParser extends SingleFormatParser {

    private Magic tmagic;
    public MagicParser(BufferedInputStream inputStream, Magic magic) {
        super(inputStream, magic);
        tmagic = magic;
    }

    public void readValue() {
        readMagicDescString();
    }

    private void readMagicDescString() {
        int length = this.bytes.length;
        tmagic.setDesc(ByteUtils.bytes2String(this.bytes,0 ,length));
    }
}
