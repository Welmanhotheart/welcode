import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;

public class TestRedisSingle {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.73.130",6379);
        System.out.println(jedis.ping());
        String bitkey = "bitkey";
        jedis.set(bitkey, "a");

        jedis.setbit(bitkey, 6, true);
        jedis.setbit(bitkey, 7, false);
        System.out.println(jedis.get(bitkey));
        String setKey = "myset";
        Long sadd = jedis.sadd(setKey, "12", "34", "56");
        ScanParams params = new ScanParams();
        params.match("[1-9]+");
        params.count(2);
        ScanResult<String> sscan = jedis.sscan(setKey, "1",params);
        List<String> result = sscan.getResult();
        for (String s : result) {
            System.out.println(s);
        }


//        JedisPool jedisPool = new JedisPool()
    }
}
