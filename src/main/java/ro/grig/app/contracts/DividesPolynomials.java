package ro.grig.app.contracts;

import ro.grig.app.Models.Polynomial;

public interface DividesPolynomials extends  PolynomialOperation{
    public Polynomial getRemainder(Polynomial P, Polynomial Q);
}
