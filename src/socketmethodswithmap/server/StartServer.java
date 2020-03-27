package socketmethodswithmap.server;

import socketmethodswithmap.server.model.PrintMessage;
import socketmethodswithmap.server.model.ReturnHello;
import socketmethodswithmap.server.model.UpperCase;
import socketmethodswithmap.server.networking.Server;

public class StartServer {

    public static void main(String[] args) {
        // the parameters here should be interface instead.
        Server server = new Server(new PrintMessage(), new ReturnHello(), new UpperCase());
        server.runServer();
    }
}
