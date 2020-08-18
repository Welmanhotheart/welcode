package project;

import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

//cat /home/admin/logs/*.log | grep "Login" | sort | uniq -c | sort -nr
public class MainTest {
    public static void main(String[] args) {
        FilePatternScannner scannner = new FilePatternScannner("D:\\text", ".*log$");
        File[] matchedFiles = scannner.getMatchedFiles();
        if (matchedFiles != null && matchedFiles.length > 0) {
            Pattern p = Pattern.compile(".*(Login)+.*");

            final List<FileMatchedTextLineCounter> threads = new ArrayList<FileMatchedTextLineCounter>(matchedFiles.length);

            CountDownLatch latch = new CountDownLatch(matchedFiles.length);

            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                    30,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5));
            try {
                for (File file : matchedFiles) {
                    FileMatchedTextLineCounter counter = new FileMatchedTextLineCounter(latch, file.getAbsolutePath(), p);
                    threads.add(counter);
                    executor.execute(counter);
                }
                executor.shutdown();
                latch.await();
                List<Map<String , Integer>> maps = new LinkedList<Map<String , Integer>>();
                for (FileMatchedTextLineCounter thread : threads) {
                    Map<String, Integer> counter = thread.getCounter();
                    maps.add(counter);
                }
                List<Map.Entry<String, Integer>> entries = doMapsMergingAndSortEntries(maps);
                for (Map.Entry<String, Integer> entry : entries) {
                    System.out.println(entry.getValue() + " " + entry.getKey());
                }
            } catch (Exception e) {

            }
        }

    }

    private static List<Map.Entry<String, Integer>> doMapsMergingAndSortEntries(List<Map<String, Integer>> maps) {


        Map<String, Integer> finalResult = new LinkedHashMap<String, Integer>();
        for (Map<String, Integer> map : maps) {
            for (String key : map.keySet()) {
                Integer integer = finalResult.get(key);
                Integer count = map.get(key);
                if (integer == null) {
                    finalResult.put(key, count);
                } else {
                    finalResult.put(key, (count + integer));
                }
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(finalResult.size());
        entries.addAll(finalResult.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return entries;
    }

    @Test
    public void testPattern(){
        Pattern p = Pattern.compile(".*(Login)+.*");
        String line = "sdfhsafjkshsdLogin";
        System.out.println(p.matcher(line).matches());

    }
}
