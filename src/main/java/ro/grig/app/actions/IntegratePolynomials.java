package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.IntegratesPolynomials;

import java.util.stream.IntStream;

public class IntegratePolynomials implements IntegratesPolynomials {
    @Override
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");
        result.setRank(P.getRank() + 1);

        IntStream.rangeClosed(0, P.getRank()).forEach(i -> result.setMonomial(
                i + 1,
                P.getMonomialCoefficient(i) / (i + 1))
        );

        return result;
    }
}
