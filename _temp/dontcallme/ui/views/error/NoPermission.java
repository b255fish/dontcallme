package com.practice.dontcallme.ui.views.error;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("no-permission")
public class NoPermission extends Div {
    public NoPermission() {
        setText("No permission.");
    }
}