package exercise.digester;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;

public class TestDigester {
    public static void main(String[] args) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("department", Department.class);
        digester.addSetProperties("department");

        digester.addObjectCreate("department/user", User.class);
        digester.addSetProperties("department/user");
        digester.addSetNext("department/user", "addUser");

        digester.addCallMethod("department/extension", "putExtension", 2);
        digester.addCallParam("department/extension/property-name", 0);
        digester.addCallParam("department/extension/property-value", 1);


        Department parse = (Department) digester.parse(Department.class.getClassLoader().getResource("test.xml"));
        System.out.println(parse);
    }
}
