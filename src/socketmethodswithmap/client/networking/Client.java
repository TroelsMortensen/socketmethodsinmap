package socketmethodswithmap.client.networking;

public interface Client {
    void sendMessageToPrint(String msg);
    String getHello();
    String toUppercase(String str);
}
