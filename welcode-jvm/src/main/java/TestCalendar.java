import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DATE));
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        System.out.println(calendar.get(Calendar.DATE));


        String[] dateBeginAndEnds = getDateBeginAndEnds(calendar);
        System.out.println(dateBeginAndEnds[0] + ";" + dateBeginAndEnds[1]);
    }

    public static String[] getDateBeginAndEnds(Calendar date) {
        if (null == date) {
            return new String[0];
        } else {
            Calendar cal = date;
            String[] date_begin_end = new String[2];
            Calendar date_start = (Calendar)cal.clone();
            date_start.set(Calendar.HOUR_OF_DAY,0);
            date_start.set(Calendar.MINUTE,0);
            date_start.set(Calendar.SECOND,0);

            Calendar date_end = (Calendar)cal.clone();
            date_end.set(Calendar.HOUR_OF_DAY,23);
            date_end.set(Calendar.MINUTE,59);
            date_end.set(Calendar.SECOND,59);
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date_begin_end[0] = sdf.format(date_start.getTime());
            date_begin_end[1] = sdf.format(date_end.getTime());
            return date_begin_end;

        }
    }

    private static final Pattern contact_phone_num_pattern  = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    /**
     * 校验11位电话号码是否是合法的
     * @param contact_phone_num
     * @return
     */
    public static boolean checkPhoneNumIsvalid(String contact_phone_num) {
//        if (StringUtil.isEmpty(contact_phone_num)) {
//            return false;
//        } else {
//            return contact_phone_num_pattern.matcher(contact_phone_num).matches();
//        }
        return false;
    }
}
