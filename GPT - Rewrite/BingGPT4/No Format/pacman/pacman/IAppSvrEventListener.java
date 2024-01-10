package com.yeshj.pacman.event;

public interface IAppSvrEventListener extends IEventListener {

    /**
     * Server started event.
     *
     * @param source
     */
    void onAppSvrStarted(Object source);

    /**
     * Server stopped event.
     *
     * @param source
     */
    void onAppSvrShutdown(Object source);

    /**
     * Server heartbeat event.
     *
     * @param source
     */
    void onAppSvrHeartBeat(Object source);

    /**
     * Server crash event.
     *
     * @param source
     */
    void onAppSvrCrash(Object source);
}
