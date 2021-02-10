package com.practice.dontcallme.ui.views.test;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;


@Route(value = "greet")
public class GreetingComponent extends Div
        implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event,
                             @OptionalParameter String parameter) {
        if (parameter == null) {
            setText("Welcome anonymous.");
        } else {
            setText(String.format("Welcome %s.",
                    parameter));
        }
    }
}