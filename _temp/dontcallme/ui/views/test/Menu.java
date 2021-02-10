package com.practice.dontcallme.ui.views.test;

import com.practice.dontcallme.ui.views.Home;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

import java.util.List;


public class Menu extends Div implements RouterLayout {
    public Menu() {
        String route = RouteConfiguration.forApplicationScope().getUrl(PathComponent.class);
        Anchor link = new Anchor(route, "Path");
        add(link);
        Div menu = new Div();
        menu.add(new RouterLink("Home", Home.class));
        menu.add(new RouterLink("Greeting",
                GreetingComponent.class, "default"));
        add(menu);

        Router router = UI.getCurrent().getRouter();
        List<RouteData> routes = RouteConfiguration.forApplicationScope().getAvailableRoutes();
    }
}