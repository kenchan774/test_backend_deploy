package com.ivelite.fokchongdev.enums;
public enum ErrorCodes implements ErrorCode{


    SUCCESS(0, "error.code.success"),
    SYSTEM_ERROR(1, "error.code.error"),
    UNKNOWN_ERROR(-1, "error.code.unknown"),
    BAD_REQUEST(400, "error.code.httpstatus.400"),
    UNAUTHORIZED(401,"error.code.httpstatus.401"),
    FORBIDDEN(403,"error.code.httpstatus.403"),
    NOT_FOUND(404,"error.code.httpstatus.404");


    private final int code;
    private final String msg;

    ErrorCodes(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "[" +  this.code + "]" + this.msg;
    }
}
