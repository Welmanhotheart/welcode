package tests;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SegmentTest {
    public static void main(String[] args) {
        String str = "/sqlserver221/my_db/dbo.huang";
        String[] split = str.split("/|\\.");
        System.out.println("sadfs\n\tafsf");
        Set<Integer> orderByEndPoints = new LinkedHashSet<Integer>(1);
        String userInput = "select * from stu order by Age , id desc ";
        String temp = userInput;
        orderByEndPoints.add(39);
        if (!orderByEndPoints.isEmpty()) {
            int size = orderByEndPoints.size();
            int capacity = 2 * size + 1;
            List<String> segments = new ArrayList<String>(capacity);
            for (int i = 0; i < capacity; i++) {
                segments.add("");
            }
            Integer[] ts = orderByEndPoints.toArray(new Integer[0]);
            //分割子sql;同时留出空位
            int start = 0,index = 0;
            for(int i = 0,len = ts.length; i < len; i++) {
                int arrival = ts[i] + 1;
                String segment = temp.substring(start, arrival);
                segments.set(index, segment);
                index += 2;
                start = arrival;
            }
            if (userInput.length() >= start) {
                segments.set(index, userInput.substring(start));
            }

            for (int i = 1; i < capacity; i += 2) {
                segments.set(i, " OFFSET 0 ROWS ");
            }

            StringBuilder builder = new StringBuilder();
            for (String segment : segments) {
                builder.append(segment);
            }
            System.out.println(builder.toString());
        }
    }
}
