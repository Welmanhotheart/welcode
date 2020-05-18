package bytecode.classFileInterpretation.factory;

import bytecode.classFileInterpretation.constants.tags.PoolConstantInfoTag;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 常量池项目解析器工厂
 */
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
            System.out.println("tag：" + read);
            if(read > 0 && read <= PoolConstantInfoTag.CONSTANT_INVOKEDYNAMIC_INFO) {
                Class<? extends Constant_info_parser> aClass = map.get((byte)read);//这里我没有加强转，直接报错
                if (null != aClass) {
                    Constructor<? extends Constant_info_parser> declaredConstructor = aClass.getDeclaredConstructor(InputStream.class);
                    declaredConstructor.setAccessible(true);
                    parser = declaredConstructor.newInstance(inputStream);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
