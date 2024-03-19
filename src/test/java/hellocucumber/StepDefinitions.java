package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ro.grig.app.Models.Polynomial;
import ro.grig.app.config.AppProvider;
import ro.grig.app.config.ConfigLoader;
import ro.grig.app.contracts.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private Polynomial P;
    private Polynomial Q;
    private String result;

    @Before
    public void setUp() {
        ConfigLoader.handle();
    }

    @Given("I have polynomial P: {string}")
    public void iHavePolynomialP(String arg0) {
        P = new Polynomial(arg0);
    }

    @And("I have polynomial Q: {string}")
    public void iHavePolynomialQ(String arg0) {
        Q = new Polynomial(arg0);
    }

    @When("I add polynomials P and Q")
    public void iAddPolynomialsPAndQ() {
        result = AppProvider.get(AddsPolynomials.class).handle(P,Q).toString();
    }

    @Then("the result is: {string}")
    public void theResultIs(String arg0) {
        assertEquals(arg0, result);
    }

    @When("I subtract polynomials P and Q")
    public void iSubtractPolynomialsPAndQ() {
        result = AppProvider.get(SubtractsPolynomials.class).handle(P,Q).toString();
    }

    @When("I multiply polynomials P and Q")
    public void iMultiplyPolynomialsPAndQ() {
        result = AppProvider.get(MultipliesPolynomials.class).handle(P,Q).toString();
    }

    @When("I divide polynomials P and Q")
    public void iDividePolynomialsPAndQ() {
        DividesPolynomials divider = AppProvider.get(DividesPolynomials.class);
        result = "Câtul este: " + divider.handle(P, Q).toString() + " și restul este: " + divider.getRemainder(P, Q).toString();
    }

    @When("I take the derivative of polynomial P")
    public void iTakeTheDerivativeOfPolynomialP() {
        result = AppProvider.get(DerivesPolynomials.class).handle(P,Q).toString();
    }

    @When("I integrate polynomial P")
    public void iIntegratePolynomialP() {
        result = AppProvider.get(IntegratesPolynomials.class).handle(P,Q).toString();
    }
}
