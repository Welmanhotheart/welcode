package bytecode.classFileInterpretation.parsing;

import bytecode.classFileInterpretation.factory.Constant_info_parserFactory;
import bytecode.classFileInterpretation.formats.infos.ConstantPoolInfo;
import bytecode.classFileInterpretation.formats.infos.Info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;

import java.io.BufferedInputStream;

public class ConstantPoolInfoParser extends InfoParser {
    private Constant_info[] constant_infos;
    public ConstantPoolInfoParser(BufferedInputStream input, ConstantPoolInfo constantPoolInfo) {
        super(input, constantPoolInfo);
        constant_infos = new Constant_info[this.format.getSize()];
    }

    public void readContent() {
        int constantCount = constant_infos.length;
        for(int i = 0; i < constantCount; i++) {
            Constant_info_parser parser = Constant_info_parserFactory.getParserInstance(this.inputStream);
            constant_infos[i] = parser.parse();
            parser.dispose();
        }
        ConstantPoolInfo constantPoolInfo = (ConstantPoolInfo) this.format;
        constantPoolInfo.setConstant_infos(constant_infos);
    }
    protected void dispose() {
        this.constant_infos = null;
       super.dispose();
    }

}
