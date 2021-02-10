package com.practice.dontcallme.ui.views.test;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;

@Route("greet2")
public class WildcardGreeting extends Div
        implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event,
                             @WildcardParameter String parameter) {
        if (parameter.isEmpty()) {
            setText("Welcome anonymous.");
        } else {
            setText(String.format(
                    "Handling parameter %s.",
                    parameter));
        }
    }
}