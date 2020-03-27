package socketmethodswithmap.server.model;

import socketmethodswithmap.shared.Request;


public class PrintMessage {


    public void printStuff(Request req) {
        System.out.println(req.arg);
    }
}
