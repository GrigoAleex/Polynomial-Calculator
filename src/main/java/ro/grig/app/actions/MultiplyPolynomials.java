package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.MultipliesPolynomials;

public class MultiplyPolynomials implements MultipliesPolynomials {
    @Override
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");

        for (int i = 0; i <= Q.getRank(); i++) {
            for (int j = 0; j <= P.getRank(); j++) {
                Double coef = P.getMonomialCoefficient(j) * Q.getMonomialCoefficient(i) + result.getMonomialCoefficient(i + j);
                result.setMonomial(i + j, coef);
            }
        }

        return result;
    }
}
