import io.lettuce.core.*;
import io.lettuce.core.Range.Boundary;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class TestResPool {
    private static String host_name = "192.168.3.17";

//    private static int port = 6379;
    private static int port = 6391;

    private static String password = "Hello123$";

    private static RedisClient client ;
    private static   RedisAsyncCommands<String, String> async;
    static {
        client = RedisClient.create(String.format("redis://%s:%s", host_name, port));
        StatefulRedisConnection<String, String> connect = client.connect();
        async = connect.async();
    }


    @Test
    public void testStringOrders() throws ExecutionException, InterruptedException {
        String key = "key";
        RedisFuture<String> set = async.set("key", "value");
        System.out.println(set.get());
        System.out.println(async.get("key").get());

        async.setnx("key", "value1");
        System.out.println(async.get("key").get());

        System.out.println(async.getrange(key, 0, 1).get());
        System.out.println(async.getrange(key, 0, -1).get());


        HashMap<String, String> stringHashMap = new HashMap<String, String>(3);
        stringHashMap.put("key1","value1");
        stringHashMap.put("key2","value2");
        stringHashMap.put("key3","value3");
        async.mset(stringHashMap);
        String[] keys = async.keys("key*").get().toArray(new String[0]);
        System.out.println(async.mget(keys).get());

        async.setex(key, 15, "nihao").get();

        async.set(key, "2").get();

        System.out.println(async.decr(key).get());
        System.out.println(async.decrby(key, -2).get());

        async.set(key, "我们的的洒家分厘卡设计的");
        System.out.println(async.strlen(key).get());

        async.set(key, "wioertwethjk");
        System.out.println(async.strlen(key).get());


        stringHashMap.clear();
        stringHashMap.put("key33","value33");
        stringHashMap.put("key4","value4");
        System.out.println(stringHashMap);
        System.out.println(async.msetnx(stringHashMap).get());


        async.set(key, "56");
        System.out.println(async.incr(key).get());
        System.out.println(async.incrby(key, 34).get());
        System.out.println(async.incrbyfloat(key, 34.7).get());

        async.set(key, "Hello , this is my book");
        async.setrange(key, 1, "you are");

        async.psetex(key, 10000, "Hello, this is my book");

        System.out.println(async.getset(key, "nihao").get());


        async.setex(key, 12, "hello, this is my book asdfsa");

        async.append(key, "you and the world");
    }



    @Test
    public void testListOrder() throws ExecutionException, InterruptedException {
        String key = "list";
        async.lpush(key, "e1", "e2", "e3");
        System.out.println(async.lindex(key, -1).get());

        async.del(key);
        async.rpush(key, "e1", "e2", "e3");
        System.out.println(async.lindex(key, -1).get());

        RedisFuture<List<String>> lrange = async.lrange(key, 0, 1);

        System.out.println(lrange.get());
        System.out.println(async.rpoplpush(key, key));


        async.del(key);
        async.rpush(key, "e2", "e3", "e4");
//        async.lrem(key, -1, "e");

        System.out.println(async.llen(key).get());


        async.ltrim(key, 0, 1);

        async.del(key);
        async.rpush(key, "e1","e2","e3", "e3", "e4");
        async.lpop(key);

        async.lpushx(key, "1" ,"2" , "3", "4");

        async.del(key);
        async.rpush(key, "e1","e2","e3", "e3", "e4");
        async.linsert(key, true, "e2", "name");
        async.linsert(key, false, "e3", "name");

//        async.rpop(key);

//        async.lset(key, 0, "e11");

        async.rpushx(key, "1" ,"2" , "3", "4");
    }

    @Test
    public void testHashOrder() throws ExecutionException, InterruptedException {
        String key = "hashmap";
        HashMap<String, String> stringStringHashMap = new HashMap<String, String>();
        stringStringHashMap.put("key1", "value1");
        stringStringHashMap.put("key2", "value2");
        stringStringHashMap.put("key3", "value3");
        stringStringHashMap.put("key4", "value4");
        stringStringHashMap.put("key5", "555");
        async.hmset(key, stringStringHashMap);

        System.out.println(async.hmget(key, "key1", "key3").get());

        async.hset(key, "key1", "value11");
        System.out.println(async.hgetall(key).get());

        System.out.println(async.hget(key, "key3").get());

        System.out.println(async.hexists(key, "key22").get());


        System.out.println(async.hexists(key, "key2").get());

        async.hincrby(key, "key5", 5);

        System.out.println(async.hlen(key).get());

        System.out.println(async.hvals(key).get());

        System.out.println(async.hkeys(key).get());

        System.out.println(async.hincrbyfloat(key, "key5", 3.45));

        async.hsetnx(key, "key6", "value6");

    }

    @Test
    public void testZSetOrder() throws ExecutionException, InterruptedException {
        String key = "keySet";
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou").get();

        async.del(key);
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();


        String key1 = "keySet1";
        async.zadd(key1, 66,"liming").get();
        async.zadd(key1, 78,"wangwu").get();
        async.zadd(key1, 67,"wangfang").get();
        async.zadd(key1, 64,"wangmi").get();
        async.zadd(key1, 89,"wanglong").get();
        async.zadd(key1, 94,"wangminghui").get();

//        System.out.println(async.zrevrank(key, "liyanglou").get());


//        Range<String> doubleRange = Range.<String>from(Boundary.<String>including("liyanglou3"), Boundary.<String>including("liyanglou5"));
//        System.out.println(async.zlexcount(key, doubleRange).get());
        async.zunionstore("key2", key, key1);


        async.del(key);
        async.del(key1);
        async.del("key2");
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();
        async.zremrangebyrank(key, 0 , 1);

        async.del(key);
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();
        System.out.println(async.zcard(key).get());

        async.zrem(key, "liyanglou1", "liyanglou3","liyanglou5").get();

        async.del(key);
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();
        System.out.println(async.zcard(key).get());
        System.out.println(async.zrank(key, "liyang").get());
        async.zincrby(key, 3, "liyanglou5");

        Range<Double> from = Range.<Double>from(Boundary.<Double>excluding(90d), Boundary.<Double>excluding(100d));
        RedisFuture<List<String>> zrangebyscore = async.zrangebyscore(key, from);
        System.out.println(zrangebyscore.get());

        async.del(key);
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();
//        async.zrangebylex()

        System.out.println(async.zscore(key, "liyanglou3").get());
        async.zremrangebyscore(key, from);

        async.del(key);
        async.zadd(key, 66,"liming").get();
        async.zadd(key, 90,"liyang").get();
        async.zadd(key, 90,"liyanglou1").get();
        async.zadd(key, 94,"liyanglou2").get();
        async.zadd(key, 92,"liyanglou3").get();
        async.zadd(key, 89,"liyanglou4").get();
        async.zadd(key, 97,"liyanglou5").get();

        ScoredValueScanCursor<String> stringScoredValueScanCursor = async.zscan(key).get();
        List<ScoredValue<String>> values = stringScoredValueScanCursor.getValues();
        for (ScoredValue<String> value : values) {
            System.out.println(value.getValue() + "=" + value.getScore());
        }
//        System.out.println(stringScoredValueScanCursor);


        System.out.println(async.zrevrangebyscore(key, from).get());

        System.out.println(async.zrevrange(key, 0, 3).get());

        System.out.println(async.zrange(key, 0, 4).get());

        System.out.println(async.zcount(key, from).get());

    }


    @Test
    public void testSetOrder() throws ExecutionException, InterruptedException {
        String key = "set";
        async.sadd(key, "1").get();
        async.sadd(key, "3").get();
        async.sadd(key, "5").get();
        async.sadd(key, "6").get();

        async.del(key);
        async.sadd(key, "1").get();
        async.sadd(key, "3").get();
        async.sadd(key, "5").get();
        async.sadd(key, "6").get();
        async.sadd(key, "6").get();

        System.out.println(async.scard(key).get());

        System.out.println(async.srandmember(key).get());

        System.out.println(async.smembers(key).get());

        async.srem(key, "1","3").get();

        async.del(key);
        async.sadd(key, "1").get();
        async.sadd(key, "3").get();
        async.sadd(key, "5").get();
        async.sadd(key, "6").get();
        async.sadd(key, "6").get();
        async.smove(key, "key2", "1");

        System.out.println(async.sismember(key, "4").get());
        System.out.println(async.sismember(key, "5").get());

        async.del(key);
        async.sadd(key, "1").get();
        async.sadd(key, "3").get();
        async.sadd(key, "5").get();
        async.sadd(key, "2").get();
        async.sadd(key, "6").get();
        async.sadd(key, "6").get();

        String key1 = "set1";
        async.sadd(key1, "1").get();
        async.sadd(key1, "3").get();
        async.sadd(key1, "5").get();
        async.sadd(key1, "4").get();
        async.sadd(key1, "6").get();
        System.out.println(async.sinter(key, key1).get());


        String key2 = "set2";
        async.sadd(key2, "1").get();
        async.sadd(key2, "3").get();
        async.sadd(key2, "5").get();
        async.sadd(key2, "22").get();
        async.sadd(key2, "6").get();

        System.out.println(async.sdiff(key, key1, key2).get());

        ValueScanCursor<String> stringValueScanCursor = async.sscan(key).get();
        for (String value : stringValueScanCursor.getValues()) {
            System.out.println(value);
        }

        System.out.println(async.ping().get().equals("PONG"));

    }


    public void testDebug() {

    }

}
