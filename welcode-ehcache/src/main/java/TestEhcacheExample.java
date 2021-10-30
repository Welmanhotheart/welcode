import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-08-2021/8/16-上午9:42
 */
public class TestEhcacheExample {
    public static void main(String[] args) {
        System.out.println(1);
        // CacheManager manager = new CacheManager();
        //创建一个缓存管理器
        CacheManager singletonManager = CacheManager.create();
        //建立一个缓存实例
        Cache memoryOnlyCache = new Cache("testCache", 5000, true, false, 5, 2);
        //在内存管理器中添加缓存实例
        singletonManager.addCache(memoryOnlyCache);
        Cache cache = singletonManager.getCache("testCache");
        //使用缓存
        Element element = new Element("key1", "value1");
        cache.put(element);
        cache.put(new Element("key1", "value2"));

        element = cache.get("key1");
        Serializable value = element.getValue();
        System.out.println(value);

        List<String> listObject = new ArrayList<String>();
        listObject.addAll(Arrays.asList("a", "b", "c"));
        cache.put(new Element("641:cardapp:tb_user",listObject));

        Element listObject1 = cache.get("641:cardapp:tb_user");
        System.out.println(listObject1.getObjectValue());

        int elementsInMemory = cache.getSize();
        System.out.println(elementsInMemory);

        long elementsInMemory2 = cache.getMemoryStoreSize();
        System.out.println(elementsInMemory2);

        Object obj = element.getObjectValue();
        cache.remove("key1");
        System.out.println(obj);



        singletonManager.shutdown();
        // manager.shutdown();
        System.out.println(2);
    }
}