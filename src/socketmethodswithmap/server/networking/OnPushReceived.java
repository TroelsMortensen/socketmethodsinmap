package socketmethodswithmap.server.networking;

import socketmethodswithmap.shared.Request;

public interface OnPushReceived {

    public void requestReceived(Request req);
}
