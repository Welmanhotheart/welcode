package bytecode.classFileInterpretation.attributes;

public class Code extends Attribute {
    private short maxStack;
    private short maxLocals;
    private int codeLength;
    private byte[] codes;
    private short exceptionTableLength;
    private ExceptionInfo[] exceptionTable;
    private short attributesCount;
    private Attribute[] attributes;

    static class ExceptionInfo {
        private short startPc;
        private short endPc;
        private short handlerPc;
        private short catchPc;

        public short getStartPc() {
            return startPc;
        }

        public void setStartPc(short startPc) {
            this.startPc = startPc;
        }

        public short getEndPc() {
            return endPc;
        }

        public void setEndPc(short endPc) {
            this.endPc = endPc;
        }

        public short getHandlerPc() {
            return handlerPc;
        }

        public void setHandlerPc(short handlerPc) {
            this.handlerPc = handlerPc;
        }

        public short getCatchPc() {
            return catchPc;
        }

        public void setCatchPc(short catchPc) {
            this.catchPc = catchPc;
        }
    }

}
