package com.yeshj.pacman.jms.message;

import com.yeshj.pacman.annotation.Transmit;

public class FeedbackMessage extends BaseMessage {

    @Transmit(key = "success")
    private boolean success = false;

    @Transmit(key = "msg")
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
