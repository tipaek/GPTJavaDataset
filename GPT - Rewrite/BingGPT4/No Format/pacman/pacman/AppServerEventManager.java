package com.yeshj.pacman.event;

public class AppServerEventManager extends EventManager<IAppSvrEventListener> {

    public static final int EVENT_SERVER_START = 0;
    public static final int EVENT_SERVER_SHUTDOWN = 1;
    public static final int EVENT_SERVER_HEARTBEAT = 2;

    private static final AppServerEventManager INSTANCE = new AppServerEventManager();

    private AppServerEventManager() {}

    public static AppServerEventManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void fireEvent(Object source, Object... params) {
        if (params.length > 0 && params[0] instanceof Integer) {
            notifyListeners(source, (Integer) params[0]);
        }
    }

    private void notifyListeners(Object source, int typeCode) {
        for (IAppSvrEventListener listener : listeners) {
            switch (typeCode) {
                case EVENT_SERVER_START:
                    listener.onAppSvrStarted(source);
                    break;
                case EVENT_SERVER_SHUTDOWN:
                    listener.onAppSvrShutdown(source);
                    break;
                case EVENT_SERVER_HEARTBEAT:
                    listener.onAppSvrHeartBeat(source);
                    break;
                default:
                    break;
            }
        }
    }
}
