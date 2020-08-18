package project;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/**
 * 匹配的文本计数器
 */
public class FileMatchedTextLineCounter implements Runnable {
    private Map<String, Integer> map;
    private String filePath;
    private final Pattern linePattern;

    private final CountDownLatch latch;

    private boolean isFinished;
    public FileMatchedTextLineCounter(CountDownLatch latch, String filePath, Pattern linePattern) {
        this.latch = latch;
        this.linePattern = linePattern;
        this.filePath = filePath;
        map = new HashMap<String, Integer>();
    }
    @Override
    public void run() {
        isFinished = false;
        try {
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                try {
                    String line = null;
                    while((line = reader.readLine()) != null) {
                        boolean match = linePattern.matcher(line).matches();
                        if (match) {
                            Integer integer = map.get(line);
                            if (integer == null) {
                                map.put(line, 1);
                            } else {
                                map.put(line, (++integer));
                            }
                        }

                    }
                } finally {
                    reader.close();
                }
            } finally {
                inputStream.close();
            }
        } catch (Exception e) {
            isFinished = true;
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            isFinished = true;
            try {
                latch.countDown();
            } catch (Exception e) {

            }
        }
    }

    public Map<String, Integer> getCounter() throws ThreadUnfinishedYetException {
        if (isFinished) {
           return map;
        }
         throw new ThreadUnfinishedYetException("thread unfinished yet");
    }
}
