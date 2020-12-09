package bytecode;

import java.util.regex.Pattern;

public class FunctionByteCode {
    public int calc(){
        int a=100;
        int b=200;
        int c=300;
        return(a+b)*c;
    }

    public static void main(String[] args) {
         Pattern contact_phone_num_pattern  = Pattern.compile("^\\d{11,12}$");
        System.out.println(contact_phone_num_pattern.matcher("13647319957").matches());
//        contact_phone_num_pattern.matcher("13647219957");
        System.out.println(checkPhoneNumIsvalid("13647s239957"));
        System.out.println(checkPhoneNumIsvalid("026261466241"));
    }

    /**
     * 固话
     */
    private static final Pattern contact_phone_num_pattern_fixed_mobile  = Pattern.compile("^\\d{11,12}$");

    /**
     * 校验11位电话号码是否是合法的
     * @param contact_phone_num
     * @return
     */
    public static boolean checkPhoneNumIsvalid(String contact_phone_num) {
        if (null == contact_phone_num) {
            return false;
        } else {
            String trim = contact_phone_num.trim();
            return contact_phone_num_pattern_fixed_mobile.matcher(contact_phone_num).matches();
        }
    }
}
