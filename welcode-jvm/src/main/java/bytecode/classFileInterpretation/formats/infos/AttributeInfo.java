package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.formats.AttributesCount;

public class AttributeInfo extends Info {
    private Attribute[] attributes;
    public AttributeInfo(AttributesCount countItem) {
        super(countItem);
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }
}
