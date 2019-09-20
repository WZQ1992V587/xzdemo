package com.xz.xzcommon.constant;

import lombok.Data;

/**
 * @author xz小泽
 * @date 2019/9/18 11:05
 **/

public class XZResponse {

    public Integer status;
    public String message;
    public Object data;
    public boolean rel = true;
    public XZResponse(){
        this.status = ResponseEnum.SUCCESS_CODE.getCode();
        this.message = ResponseEnum.SUCCESS_CODE.getMessage();
    }

    public Integer getStatus() {
        return status;
    }

    public XZResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public XZResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public XZResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public boolean isRel() {
        return rel;
    }

    public XZResponse setRel(boolean rel) {
        this.rel = rel;
        return this;
    }

    public static enum ResponseEnum {

        SUCCESS_CODE(1, "成功"),
        FAILED_CODE(0, "失败");

        ResponseEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer code;

        public String message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
