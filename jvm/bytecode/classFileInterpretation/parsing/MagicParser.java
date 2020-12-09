package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.formats.Magic;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.BufferedInputStream;

public class MagicParser extends SingleFormatParser {


    public MagicParser(BufferedInputStream inputStream, Magic magic) {
        super(inputStream, magic);

    }

    public void readValue() {
        readMagicDescString();
    }

    private void readMagicDescString() {
        Magic magic = (Magic) this.format;
        magic.setDesc(ByteUtils.toHexString(this.bytes));
    }

}
