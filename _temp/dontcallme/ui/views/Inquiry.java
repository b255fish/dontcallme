package com.practice.dontcallme.ui.views;

import com.practice.dontcallme.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@PageTitle("1:1 Inquiry support")
@Route(value = "Inquiry", layout = MainLayout.class)
public class Inquiry extends VerticalLayout {

    public Inquiry() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
    }
}

