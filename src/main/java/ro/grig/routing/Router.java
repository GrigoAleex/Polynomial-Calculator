package ro.grig.routing;

import ro.grig.routing.contracts.IRequest;

import java.util.ArrayList;

public class Router {
    public final ArrayList<Route> routes = new ArrayList<>();
    public static Router instance =  new Router();

    public static void add(Route route) { instance.routes.add(route); }
    public static void go(String routeName) { go(routeName, null); }
    public static void go(String routeName, IRequest request) {
        for (Route route : instance.routes)
            if (route.name.equals(routeName))
                route.execute(request);
    }
}
