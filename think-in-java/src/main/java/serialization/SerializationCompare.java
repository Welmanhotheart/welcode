package serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-07-2021/7/19-下午5:13
 */
public class SerializationCompare {

    public static List<List<String>> dataList= new ArrayList();

    public static List<String> list = new ArrayList<>();
    static {

        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));
        dataList.add(new ArrayList<>(Arrays.asList("abc", "bcd", "cde", "def")));

    }

    public static void main(String[] args) throws FileNotFoundException {
        testKryoSerializationAndDeserialization();
    }

    public static void testKryoSerializationAndDeserialization() throws FileNotFoundException {
        File dataFile = new File("data.dat");
        Kryo kryo = new Kryo();
        Output output = null;
        long l = System.currentTimeMillis();
        output = new Output(new FileOutputStream(dataFile));
        for (int i = 0; i < 10000; i++) {
            kryo.writeObject(output, dataList);
        }

        Input input = null;

        input = new Input(new FileInputStream(dataFile));
        for (int i = 0; i < 10000; i++) {
            kryo.readObject(input, ArrayList.class);
        }

        System.out.println("耗时:" + (System.currentTimeMillis() - l));
    }
}