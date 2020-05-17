package bytecode.classFileInterpretation.factory;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;
import bytecode.classFileInterpretation.formats.infos.constantPool.*;
import bytecode.classFileInterpretation.parsing.Constant_info_parser;
import bytecode.classFileInterpretation.parsing.constantConcreteInfoParsers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Constant_info_parserFactory {
    static final Map<Byte, Class<? extends Constant_info_parser>> map = new ConcurrentHashMap<Byte, Class<? extends Constant_info_parser>>();
    static {
        map.put(PoolConstantInfoTag.CONSTANT_UTF8_INFO, Constant_UTF8_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_INTEGER_INFO, Constant_Integer_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_FLOAT_INFO, Constant_Float_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_LONG_INFO, Constant_Long_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_DOUBLE_INFO, Constant_Double_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_CLASS_INFO, Constant_Class_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_STRING_INFO, Constant_String_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_FIELDREF_INFO, Constant_Fieldref_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_METHODREF_INFO, Constant_Methodref_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_INTERFACEMETHODREF_INFO, Constant_Interface_Methodref_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_NAMEANDTYPE_INFO, Constant_Name_Type_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_METHODHANDLE_INFO, Constant_Method_Handle_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_METHODTYPE_INFO, Constant_Method_Type_info_parser.class);
        map.put(PoolConstantInfoTag.CONSTANT_INVOKEDYNAMIC_INFO, Constant_Invoke_Dynamic_info_parser.class);
    }
    public static Constant_info_parser getParserInstance(InputStream inputStream) {
        Constant_info_parser parser = null;
        try {
            int read = inputStream.read();
            if(read > 0 && read <= PoolConstantInfoTag.CONSTANT_INVOKEDYNAMIC_INFO) {
                Class<? extends Constant_info_parser> aClass = map.get(read);
                if (null != aClass) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
