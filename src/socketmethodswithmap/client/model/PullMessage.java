package socketmethodswithmap.client.model;

import socketmethodswithmap.client.networking.Client;

public class PullMessage {

    private Client client;

    public PullMessage(Client client) {
        this.client = client;
    }

    public void doStuff() {
        String hello = client.getHello();
        System.out.println(hello);
        String result = client.toUppercase("Hello wOrLd");
        System.out.println(result);
    }
}
