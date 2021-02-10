package com.practice.dontcallme.ui.views.test;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;

@PageTitle("Path test!")
@Route(value="path", layout=Menu.class)
public class PathComponent extends Div {
    public PathComponent() {
        setText("Hello @Route!");
    }
}

