package socketmethodswithmap.shared;

import java.io.Serializable;

public class Request implements Serializable {
    public boolean isPull;
    public String requestType;

    public Object arg;

    public Request(boolean isPull, String requestType, Object arg) {
        this.isPull = isPull;
        this.requestType = requestType;
        this.arg = arg;
    }
}
