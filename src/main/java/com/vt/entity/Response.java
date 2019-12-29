package com.vt.entity;

public class Response {
    String msg;
    int code;
    Boolean issue = true;

    public Response(){}
    public Response(String msg,int code,Boolean issue){
        this.code=code;
        this.msg=msg;
        this.issue=issue;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Boolean getIssue() {
        return issue;
    }
    public void setIssue(Boolean issue) {
        this.issue=issue;
    }
}