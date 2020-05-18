package bytecode.classFileInterpretation.attributes;

public class InnerClasses extends Attribute{
    private short numberOfClasses;
    private InnerClassInfo[] innerClasses;

    static class InnerClassInfo {
        private short innerClassInfoIndex;
        private short outerClassInfoIndex;
        private short innerNameIndex;
        private short innerClassAccessFlags;
    }
}
