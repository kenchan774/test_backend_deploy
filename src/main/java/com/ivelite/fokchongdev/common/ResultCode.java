package com.ivelite.fokchongdev.common;

/**
 * 常用API返回对象
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    VALIDATE_FAILED(404, "Invalid Parameter"),
    UNAUTHORIZED(401, "Unauthorized Login"),
    FORBIDDEN(403, "Unauthorized Access");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
