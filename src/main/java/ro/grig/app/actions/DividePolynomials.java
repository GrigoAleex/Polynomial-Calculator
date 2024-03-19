package ro.grig.app.actions;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.config.AppProvider;
import ro.grig.app.contracts.AddsPolynomials;
import ro.grig.app.contracts.DividesPolynomials;
import ro.grig.app.contracts.MultipliesPolynomials;
import ro.grig.app.contracts.SubtractsPolynomials;

import java.util.Map;

public class DividePolynomials implements DividesPolynomials {
    public Polynomial handle(Polynomial P, Polynomial Q) {
        return  compute(P, Q, false);
    }
    public Polynomial getRemainder(Polynomial P, Polynomial Q) {
        return  compute(P, Q, true);
    }

    // Daca vreau sa fac impartirea trebuie rulata aceasta functie de 2 ori. as putea face un cache cu cele mai recente
    // impartiri si sa iau de acolo ce am nevoie
    private Polynomial compute(Polynomial P, Polynomial Q, Boolean returnReminder) {
        if (Q.getRank() > P.getRank()) return returnReminder ? P : new Polynomial("");

        Polynomial remainder = P;
        remainder.setRank(P.getRank());


        int rankQ = Q.getRank();
        Double qMonomialCoefficient = Q.getMonomialCoefficient(Q.getRank());

        Polynomial result = new Polynomial("");

        SubtractsPolynomials subtractor = AppProvider.get(SubtractsPolynomials.class);
        MultipliesPolynomials multiplier = AppProvider.get(MultipliesPolynomials.class);
        AddsPolynomials adder = AppProvider.get(AddsPolynomials.class);

        while (rankQ <= remainder.getRank()) {
            Polynomial quotient = new Polynomial("");
            quotient.setMonomial(
        remainder.getRank() - rankQ,
        remainder.getMonomialCoefficient(remainder.getRank()) / qMonomialCoefficient
            );
            quotient.setRank(remainder.getRank() - rankQ);

            result = adder.handle(result, quotient);

            remainder = subtractor.handle(remainder, multiplier.handle(Q, quotient));
            remainder.updateRank();
        }

        return returnReminder ? remainder : result;
    }
}
