package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.DerivesPolynomials;

public class DerivePolynomials implements DerivesPolynomials {
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");

        for (int i = 1; i <= P.getRank(); i++) {
            result.setMonomial(i - 1, P.getMonomialCoefficient(i) * i);
        }

        return result;
    }
}
