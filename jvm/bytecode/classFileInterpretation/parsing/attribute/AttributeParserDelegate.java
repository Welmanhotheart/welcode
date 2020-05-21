package bytecode.classFileInterpretation.parsing.attribute;

import bytecode.classFileInterpretation.ClassFormat;
import bytecode.classFileInterpretation.attributes.Attribute;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_UTF8_info;
import bytecode.classFileInterpretation.formats.infos.constantPool.Constant_info;
import bytecode.classFileInterpretation.parsing.RuntimeVisibleAnnotationsParser;
import bytecode.classFileInterpretation.util.ByteUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AttributeParserDelegate extends AttributeParser{

    static final Map<String, Class<? extends AttributeParser>> map = new ConcurrentHashMap<String, Class<? extends AttributeParser>>();
    static {
        map.put("CONSTANTVALUE", ConstantValueParser.class);//done
        map.put("DEPRECATED", DeprecatedParser.class);//done
        map.put("SIGNATURE", SignatureParser.class);//done
        map.put("SYNTHETIC", SyntheticParser.class);//done
        map.put("RUNTIMEVISIBLEANNOTATIONS", RuntimeVisibleAnnotationsParser.class);
        map.put("RUNTIMEINVISIBLEANNOTATIONS", RuntimeInvisibleAnnotationsParser.class);
    }

    public AttributeParserDelegate(InputStream input, ClassFormat classFormat) {
        super(input, classFormat);
    }

    public Attribute doParse() {
        readAttributeNameIndex();
        readAttributeLength();
        AttributeParser attributeParser = getAttributeParser();
        attributeParser.setAttributeNameIndex(this.attributeNameIndex);
        attributeParser.setAttributeLength(this.attributeLength);
        return attributeParser.parse();
    }


    /**
     * 获取具体的解析器
     * @return
     */
    private AttributeParser getAttributeParser() {
        AttributeParser attributeParser = null;
        Constant_info utf8_info = this.classFormat.getCp_info(this.attributeNameIndex);
        String desc = ((Constant_UTF8_info) utf8_info).getDesc();
        Class<? extends AttributeParser> parserClass = map.get(desc.toUpperCase());
        try {
            Constructor<? extends AttributeParser> declaredConstructor = parserClass.getDeclaredConstructor(InputStream.class, ClassFormat.class);
            try {
                attributeParser = declaredConstructor.newInstance(this.inputStream, this.classFormat);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return attributeParser;
    }


    private void readAttributeNameIndex() {
        try {
            this.attributeNameIndex = ByteUtils.readShort(this.inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAttributeLength() {
        try {
            this.attributeLength = ByteUtils.readInt(this.inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
