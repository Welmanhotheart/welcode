package com.wei.java.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2021-01-2021/1/13-下午2:11
 */
public class TestDate {

    @Test
    public void testBeforeServeralDays() {
        Date date = new Date();
        long time = 7 * 24 * 60 * 60 * 1000;
        date.setTime(System.currentTimeMillis() - time);
        System.out.println(date);
    }

    @Test
    public void testBeforeServeralDays2() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -500);
        System.out.println(calendar.getTime());
    }

    @Test
    public void testSimpleDateFormat() {
        Date date = new Date();
        SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String format = dateTimeFormatter.format(date);
        System.out.println(format);

    }

}
