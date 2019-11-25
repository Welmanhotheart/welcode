package memory.oom;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOML {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

    }

}

// -XX:PermSize=10M -XX:MaxPermSize=10M