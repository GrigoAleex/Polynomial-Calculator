package ro.grig.app.controllers;

import ro.grig.app.Models.Polynomial;
import ro.grig.app.config.AppProvider;
import ro.grig.app.config.CalculatorProvider;
import ro.grig.app.contracts.DividesPolynomials;
import ro.grig.app.requests.PolynomialCalculateRequest;
import ro.grig.frontend.Window;
import ro.grig.frontend.exceptions.ViewNotFoundException;
import ro.grig.frontend.exceptions.WindowUninitializedException;
import ro.grig.routing.Router;
import ro.grig.routing.Session;
import ro.grig.routing.contracts.IController;

import java.io.IOException;
import java.util.Objects;

public class PolynomialController implements IController {
    public static void index() {
        try {
            Window.setView("/home");
        } catch (WindowUninitializedException e) {
            System.err.println(e.getMessage());
            System.exit(11);
        } catch (ViewNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(12);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(121);
        }
    }

    public static void calculate(PolynomialCalculateRequest request)
    {
        if (!CalculatorProvider.getAvailableOperations().contains(request.operation)) {
            Session.set("error", "Operația selectată nu există");
            Router.go("home");
            return;
        }

        Polynomial P = new Polynomial(request.P);
        Polynomial Q = new Polynomial(request.Q);

        if (Q.getRank() == 0 && Objects.equals(request.operation, "divide")) {
            Session.set("error", "Nu poți împărții la zero");
            Router.go("home");
            return;
        }

        Session.set("result", compute(request.operation, P, Q));
        Router.go("home");
    }


    private static String compute(String operation, Polynomial P, Polynomial Q) {
        if (operation.equals("divide")) {
            DividesPolynomials divider = AppProvider.get(DividesPolynomials.class);
            return "Câtul este: " + divider.handle(P, Q).toString() +
                    " și restul este: " + divider.getRemainder(P, Q).toString();
        }

        return AppProvider.get(CalculatorProvider.get(operation)).handle(P, Q).toString();
    }
}
