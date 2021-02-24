import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.RedisClusterURIUtil;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import org.junit.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-02-2021/2/23-下午9:53
 */
public class TestRedisCluster {

    private static String host_name = "192.168.3.17";

    //    private static int port = 6379;
    private static int port = 6479;

    private static String password = "Hello123$";

    private static RedisClusterClient client ;
    private static RedisAdvancedClusterAsyncCommands<String, String> async;
//    private static String nodes = "192.168.3.17:6391";
//    private static String nodes = "192.168.3.17:6391,192.168.3.17:6392,192.168.3.17:6393,192.168.3.17:6394,192.168.3.17:6395,192.168.3.17:6396";
    private static String nodes = "192.168.3.17:6391,192.168.3.17:6392,192.168.3.17:6393";
    static {

        List<RedisURI> redisURIS = new ArrayList<RedisURI>(6);
        for (String part : nodes.split(",")) {
            final String[] hostAndPort = part.split(":");
            final RedisURI redisURI = RedisURI.builder().withHost(hostAndPort[0]).withPort(Integer.parseInt(hostAndPort[1])).withDatabase(0).build();
            redisURIS.add(redisURI);
        }
        client = RedisClusterClient.create(redisURIS);
        final StatefulRedisClusterConnection<String, String> connect = client.connect();
        async = connect.async();
    }

    @Test
    public void testConnect() {
        System.out.println(async);
    }

    @Test
    public void testWrite() {
        async.set("local:session:write:a786442d-701b-4c8a-8464-a34408a33f4565h9cererfghe", "value");
    }

}
