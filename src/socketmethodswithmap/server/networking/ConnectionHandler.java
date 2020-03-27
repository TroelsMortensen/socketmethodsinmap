package socketmethodswithmap.server.networking;

import socketmethodswithmap.shared.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    private Server server;
    private final Socket socket;

    public ConnectionHandler(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        // some classes implements java.io.Closeable, and if I do the following line
        // the socket object will be closed after the try-catch
        try(socket) {
            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

            while(true) {
                Request request = (Request) inFromClient.readObject();
                if(request.isPull) {
                    Object result = server.callPullMethod(request);
                    outToClient.writeObject(result);
                } else {
                    server.callPushMethod(request);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
