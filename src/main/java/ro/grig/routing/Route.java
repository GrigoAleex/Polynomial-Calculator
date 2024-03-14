package ro.grig.routing;

import ro.grig.routing.contracts.IController;
import ro.grig.routing.contracts.IControllerRunner;
import ro.grig.routing.contracts.IRequest;

public class Route {
    public String name;
    public IControllerRunner controller;

    public Route(String name, Class<? extends IController> controller, String action) {
        this.name = name;
        this.controller = new ControllerRunner(controller, action);
    }

    public void execute(IRequest request) {
        controller.run(request);
    }
}
