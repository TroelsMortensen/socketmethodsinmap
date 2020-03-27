package socketmethodswithmap.server.networking;

import socketmethodswithmap.server.model.PrintMessage;
import socketmethodswithmap.server.model.ReturnHello;
import socketmethodswithmap.server.model.UpperCase;
import socketmethodswithmap.shared.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

    private Map<String, OnPullReceived> pullMethods;
    private Map<String, OnPushReceived> pushMethods;

    public Server(PrintMessage pm, ReturnHello rh, UpperCase uc) {
        pullMethods = new HashMap<>();
        pushMethods = new HashMap<>();


        // add all methods here, that the ConnectionHandler can call.
        pullMethods.put("GET_HELLO", req -> rh.returnHello());
        pullMethods.put("UPPERCASE", req -> uc.toUpperCase((String)req.arg));

        pushMethods.put("PRINT_MSG", pm::printStuff);
    }

    public void runServer() {

        System.out.println("Starting server...");
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while(true) {
                Socket socket = welcomeSocket.accept();
                ConnectionHandler ch = new ConnectionHandler(socket, this);
                (new Thread(ch)).start();
            }
        } catch (IOException e) {
        }
    }

    public Object callPullMethod(Request req) {
        return pullMethods.get(req.requestType).requestReceived(req);
    }

    public void callPushMethod(Request req) {
        pushMethods.get(req.requestType).requestReceived(req);
    }
}
