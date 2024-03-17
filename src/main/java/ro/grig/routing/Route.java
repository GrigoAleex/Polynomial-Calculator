package ro.grig.routing;

import ro.grig.routing.contracts.IController;
import ro.grig.routing.contracts.IControllerRunner;
import ro.grig.routing.contracts.IRequest;

public class Route {
    private final String name;
    private final IControllerRunner controller;

    public Route(String name, Class<? extends IController> controller, String action) {
        this.name = name;
        this.controller = new ControllerRunner(controller, action);
    }

    public String getName() { return name; }

    public void execute(IRequest request) {
        controller.run(request);
    }
}
