package socketmethodswithmap.client.model;

import socketmethodswithmap.client.networking.Client;

public class PushMessage {

    private Client client;

    public PushMessage(Client client) {
        this.client = client;
    }


    public void doStuff() {
        client.sendMessageToPrint("Print this stuff");
    }
}
