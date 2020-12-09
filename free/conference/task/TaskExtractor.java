package conference.task;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Task Extractor
 * Function：extract relative tasks by deciphering the text from file "task_input_file.txt"
 */
public class TaskExtractor {

    private String filePath;

    public TaskExtractor(String filePath) {
        this.filePath = filePath;
    }

    /**
     * do detailed extraction to obtain the tasks
     * @return
     * @throws IOException
     */
    public List<Task> extract() throws IOException {
        InputStream in = new FileInputStream(filePath);
        List<Task> tasks = null;
        try {
            InputStreamReader isr = new InputStreamReader(in);
            try {
                BufferedReader reader = new BufferedReader(isr);
                try{
                    String line = reader.readLine();
                    int index = 0;
                    tasks = new ArrayList<Task>();
                    while (line != null) {
                        line = line.trim();
                        String[] split = line.split("\\s+");
                        int lineLen = line.length();
                        if (split != null && split.length >=2) {
                            Task task = new Task();
                            tasks.add(task);
                            task.setIndex(index++);
                            int length = split.length;
                            String s = split[length - 1];
                            if (s.matches("\\d+min")) {
                                int slen = s.length();
                                task.setName(line.substring(0,lineLen -1- slen));
                                String timeStr = s.substring(0, slen - 3);
                                int time = Integer.parseInt(timeStr);
                                task.setDuration(time);

                            } else {
                                task.setName(line);
                                task.setDuration(0);
                            }
                        }
                        line = reader.readLine();
                    }
                } finally {
                    reader.close();
                }
            } finally {
                isr.close();
            }
        } finally {
            in.close();
        }
        return tasks;
    }

}
