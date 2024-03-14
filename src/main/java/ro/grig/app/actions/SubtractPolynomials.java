package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.SubtractsPolynomials;

import static java.lang.Math.max;

public class SubtractPolynomials implements SubtractsPolynomials {
    @Override
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");
        int rankMax = max(P.getRank(), Q.getRank());
        result.setRank(rankMax);

        for (int i = 0; i <= rankMax; i++) {
            result.setMonomial(i, P.getMonomialCoefficient(i) - Q.getMonomialCoefficient(i));
        }

        result.updateRank();
        return result;
    }
}
