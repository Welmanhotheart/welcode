package bytecode.classFileInterpretation.formats.infos;

import bytecode.classFileInterpretation.formats.ConstantPoolCount;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

public class ConstantPoolInfo extends Info {
    private Constant_info[] constant_infos;
    public ConstantPoolInfo(ConstantPoolCount item) {
        super(item);
    }

    public void setConstant_infos(Constant_info[] constant_infos) {
        this.constant_infos = constant_infos;
    }

    public Constant_info[] getConstant_infos() {
        return constant_infos;
    }
}
