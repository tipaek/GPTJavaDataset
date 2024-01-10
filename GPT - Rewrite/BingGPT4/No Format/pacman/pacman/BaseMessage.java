package com.yeshj.pacman.jms.message;

import com.yeshj.pacman.annotation.Transmit;

public abstract class BaseMessage {

    @Transmit(key = "id")
    private int commandId;

    @Transmit(key = "type")
    private int commandType;

    @Transmit(key = "free")
    private boolean free;

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
