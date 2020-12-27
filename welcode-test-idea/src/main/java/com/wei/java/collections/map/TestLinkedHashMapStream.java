package com.wei.java.collections.map;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestLinkedHashMapStream {
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", null);
        map.put("key4", "value4");
        List<Object> collect = map.values().stream().collect(Collectors.toList());
        System.out.println(collect);
    }
}
