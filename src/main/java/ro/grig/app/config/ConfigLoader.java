package ro.grig.app.config;

import ro.grig.app.actions.*;
import ro.grig.app.contracts.*;
import ro.grig.app.controllers.PolynomialController;
import ro.grig.routing.Route;
import ro.grig.routing.Router;

public class ConfigLoader {
    public static void handle() {
        Router.add(new Route("home", PolynomialController.class, "index"));
        Router.add(new Route("calculate", PolynomialController.class, "calculate"));

        AppProvider.set(AddsPolynomials.class, new AddPolynomials());
        AppProvider.set(SubtractsPolynomials.class, new SubtractPolynomials());
        AppProvider.set(MultipliesPolynomials.class, new MultiplyPolynomials());
        AppProvider.set(DividesPolynomials.class, new DividePolynomials());
        AppProvider.set(DerivesPolynomials.class, new DerivePolynomials());
        AppProvider.set(IntegratesPolynomials.class, new IntegratePolynomials());

        CalculatorProvider.set("add", AddsPolynomials.class);
        CalculatorProvider.set("subtract", SubtractsPolynomials.class);
        CalculatorProvider.set("multiply", MultipliesPolynomials.class);
        CalculatorProvider.set("divide", DividesPolynomials.class);
        CalculatorProvider.set("derive", DerivesPolynomials.class);
        CalculatorProvider.set("integrate", IntegratesPolynomials.class);
    }
}
