package ro.grig;

import javafx.application.Application;
import javafx.stage.Stage;
import ro.grig.app.actions.*;
import ro.grig.app.config.AppProvider;
import ro.grig.app.config.CalculatorProvider;
import ro.grig.app.contracts.*;
import ro.grig.app.controllers.PolynomialController;
import ro.grig.frontend.Window;
import ro.grig.routing.Route;
import ro.grig.routing.Router;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    public void start(Stage primaryStage) {
        new Window(primaryStage);

        Router.go("home");
    }

    public static void main(String[] args) {
        loadConfig();
        launch(args);
    }

    private static void loadRoutes() {
        Router.add(new Route("home", PolynomialController.class, "index"));
        Router.add(new Route("calculate", PolynomialController.class, "calculate"));
    }

    private static void loadConfig() {
        loadRoutes();
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