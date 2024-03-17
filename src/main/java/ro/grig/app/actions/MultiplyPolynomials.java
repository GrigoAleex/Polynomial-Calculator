package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.contracts.MultipliesPolynomials;

import java.util.stream.IntStream;

public class MultiplyPolynomials implements MultipliesPolynomials {
    @Override
    public Polynomial handle(Polynomial P, Polynomial Q) {
        Polynomial result = new Polynomial("");
        result.setRank(P.getRank() + Q.getRank());

        IntStream.rangeClosed(0, Q.getRank()).forEach(i -> IntStream.rangeClosed(0, P.getRank()).forEach(j -> {
            Double coef = P.getMonomialCoefficient(j) * Q.getMonomialCoefficient(i) + result.getMonomialCoefficient(i + j);
            result.setMonomial(i + j, coef);
        }));

        return result;
    }
}
