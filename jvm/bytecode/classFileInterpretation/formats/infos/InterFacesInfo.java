package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.formats.InterfacesCount;

public class InterFacesInfo extends Info {
    private short[] indexes;
    public InterFacesInfo(InterfacesCount item) {
        super(item);
    }

    public void setIndexes(short[] indexes) {
        this.indexes = indexes;
    }
}
