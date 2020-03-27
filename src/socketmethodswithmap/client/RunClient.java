package socketmethodswithmap.client;

import socketmethodswithmap.client.model.PullMessage;
import socketmethodswithmap.client.model.PushMessage;
import socketmethodswithmap.client.networking.Client;
import socketmethodswithmap.client.networking.ClientImpl;

public class RunClient {

    public static void main(String[] args) {
        Client instance = new ClientImpl();
        PullMessage puller = new PullMessage(instance);
        puller.doStuff();
        PushMessage pusher = new PushMessage(instance);
        pusher.doStuff();
    }
}
