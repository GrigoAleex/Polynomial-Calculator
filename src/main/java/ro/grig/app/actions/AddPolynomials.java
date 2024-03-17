package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.AddsPolynomials;

import java.util.stream.IntStream;

import static java.lang.Math.max;

public class AddPolynomials implements AddsPolynomials {
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");
        int rankMax = max(P.getRank(), Q.getRank());

        result.setRank(rankMax);
        IntStream.rangeClosed(0, rankMax).forEach(i -> result.setMonomial(
                i,
                P.getMonomialCoefficient(i) + Q.getMonomialCoefficient(i))
        );

        return result;
    }
}
