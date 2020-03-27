package socketmethodswithmap.server.networking;

import socketmethodswithmap.shared.Request;

public interface OnPullReceived {

    Object requestReceived(Request req);
}
