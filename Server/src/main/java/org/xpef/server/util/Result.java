package org.xpef.server.util;

import core.util.ResponseCode;
import lombok.Getter;

import java.io.Serializable;

/**
 * 返回对象
 **/
@Getter
public class Result<T> implements Serializable {


    Boolean success = true;


    String errMsg = null;

    /**
     * 返回值
     */
    private T data = null;

    /**
     * 默认构造函数，错误码为OK
     */
    public Result() {
    }

    /**
     * 带值构造函数
     * @param data 返回值
     */
    public Result(T data) {
        this();
        this.data = data;
    }

    public Result(Boolean success,String errMsg){
        this.success=success;
        this.errMsg=errMsg;
    }


}
