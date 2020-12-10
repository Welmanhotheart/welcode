package com.wei.java.exception.model;

/***
 * TODO
 * @author <a href="zhiwei.wei@bintools.cn">zhiwei.wei</a>
 * @version 1.0.0 2020-11-2020/11/18-下午6:01
 */
public class BusinessException extends Exception{

    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }
}