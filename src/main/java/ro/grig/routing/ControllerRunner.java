package ro.grig.routing;

import ro.grig.routing.contracts.IController;
import ro.grig.routing.contracts.IControllerRunner;
import ro.grig.routing.contracts.IRequest;

import java.lang.reflect.Method;

public class ControllerRunner implements IControllerRunner {
    private final String action;
    private final Class<? extends IController> controller;

    public ControllerRunner(Class<? extends IController> controller, String action) {
        this.controller = controller;
        this.action = action;
    }

    public void run(IRequest request) {
        try {
            if (request == null) {
                Method method = controller.getMethod(this.action);
                method.invoke(null);
            } else {
                Method method = controller.getMethod(this.action, request.getClass());
                method.invoke(null, request);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
