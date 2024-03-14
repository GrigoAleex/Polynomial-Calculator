package ro.grig.app.contracts;

import ro.grig.app.Models.Polynomial;

public interface PolynomialOperation {
    public Polynomial handle(Polynomial P, Polynomial Q);
}
