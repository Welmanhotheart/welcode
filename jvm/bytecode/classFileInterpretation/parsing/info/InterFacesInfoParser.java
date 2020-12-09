package bytecode.classFileInterpretation.parsing.info;

import bytecode.classFileInterpretation.formats.infos.InterFacesInfo;
import bytecode.classFileInterpretation.parsing.info.InfoParser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.BufferedInputStream;
import java.io.IOException;

public class InterFacesInfoParser extends InfoParser {
    private short[] indexes;

    public InterFacesInfoParser(BufferedInputStream input, InterFacesInfo interFacesInfo) {
        super(input, interFacesInfo);
    }

    public void readContent() {
        try {
            fillIndexes();
        } catch (IOException e) {
            //TODO
        }
        InterFacesInfo interFacesInfo = (InterFacesInfo) this.format;
        interFacesInfo.setIndexes(this.indexes);
    }

    private void fillIndexes() throws IOException {
        int size = this.format.getSize();
        indexes = new short[size];
        for (int i = 0; i < size; i++) {
            indexes[i] = ByteUtils.readShort(this.inputStream);
        }
    }

    @Override
    protected void dispose() {
        indexes = null;
        super.dispose();
    }
}
