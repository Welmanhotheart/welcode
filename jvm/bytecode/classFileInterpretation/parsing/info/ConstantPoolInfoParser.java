package bytecode.classFileInterpretation.parsing.info;

import bytecode.classFileInterpretation.factory.Constant_info_parserFactory;
import bytecode.classFileInterpretation.formats.infos.ConstantPoolInfo;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.info.constantPool.Constant_info_parser;

import java.io.BufferedInputStream;

public class ConstantPoolInfoParser extends InfoParser {
    private Constant_info[] constant_infos;
    public ConstantPoolInfoParser(BufferedInputStream input, ConstantPoolInfo constantPoolInfo) {
        super(input, constantPoolInfo);
        constant_infos = new Constant_info[this.format.getSize() ];
    }

    public void readContent() {
        int constantCount = constant_infos.length;
        for(int i = 1; i < constantCount; i++) {
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
