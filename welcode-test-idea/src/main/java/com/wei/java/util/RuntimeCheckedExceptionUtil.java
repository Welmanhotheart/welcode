package com.wei.java.util;



/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2020-11-2020/11/18-下午5:34
 */
public class RuntimeCheckedExceptionUtil {

    public static <T extends Throwable>  void throwsException( T customizedException , Throwable receivedException) throws T {
        throw getWrappedException(customizedException, receivedException);
    }


    public static <T extends RuntimeException> void throwRunTimeException(T customizedException,  Throwable receivedException) {
        throw getWrappedException(customizedException, receivedException);
    }

    public static  RuntimeException getRunTimeException(Throwable receivedException) {
        return getWrappedException(new RuntimeException(), receivedException);
    }

    public static <T extends Throwable>  T getWrappedException( T customizedException , Throwable receivedException) {
        customizedException.initCause(receivedException);
        return customizedException;
    }

}