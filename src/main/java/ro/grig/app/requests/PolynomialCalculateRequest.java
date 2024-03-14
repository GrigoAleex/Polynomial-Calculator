package ro.grig.app.requests;

import ro.grig.routing.contracts.IRequest;

public class PolynomialCalculateRequest implements IRequest {
    public String P;
    public String Q;
    public String operation;

    public PolynomialCalculateRequest(String P, String Q, String op) {
        this.P = P;
        this.Q = Q;
        this.operation = op;
    }
}
