package com.xxx.entity;

public class Response<T> {
    private String msg;
    private int status;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;

    public Response() {
    }

    public Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
