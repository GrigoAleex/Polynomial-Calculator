package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.IntegratesPolynomials;

public class IntegratePolynomials implements IntegratesPolynomials {
    @Override
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");

        for (int i = 0; i <= P.getRank(); i++) {
            result.setMonomial(i + 1, P.getMonomialCoefficient(i) / (i + 1));
        }

        return result;
    }
}
