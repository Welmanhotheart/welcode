package com.wei.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.junit.Test;

import java.util.Arrays;

public class MongoConnectionTest {

    public static String  connectionUrl = "192.168.1.221";
    public static int  connectionPort = 27017;
    public static String  userName = "admin";
    public static String  password = "Hello123$";
    public static String DEFAULT_AUTH_DATABASE = "admin";

    @Test
    public void testCreateConnection() {
        MongoCredential credential = MongoCredential.createScramSha1Credential(userName, DEFAULT_AUTH_DATABASE, password.toCharArray());
        MongoClient client = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Arrays.asList(new ServerAddress(connectionUrl, connectionPort)))).credential(credential)
                        .build());

        System.out.println(client);

    }
}
