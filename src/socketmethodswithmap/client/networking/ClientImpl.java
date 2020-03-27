package socketmethodswithmap.client.networking;

import socketmethodswithmap.shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientImpl implements Client{

    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;


    public ClientImpl() {
        try {
            Socket socket = new Socket("localhost", 2910);
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {

        }
    }

    public void sendMessageToPrint(String msg) {
        try {
            Request req = new Request(false, "PRINT_MSG", msg);
            outToServer.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }
    }

    public String getHello() {
        try {
            Request req = new Request(true, "GET_HELLO", null);
            outToServer.writeObject(req);
            String response = (String) inFromServer.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }
    }

    public String toUppercase(String str) {
        try {
            Request req = new Request(true, "UPPERCASE", str);
            outToServer.writeObject(req);
            String response = (String) inFromServer.readObject();
            return response;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Something went wrong");
        }
    }
}
