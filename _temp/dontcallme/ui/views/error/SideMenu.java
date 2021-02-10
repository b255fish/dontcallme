package com.practice.dontcallme.ui.views.error;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;

// Marking the active navigation element as active.
public class SideMenu extends Div
        implements AfterNavigationObserver {
    Anchor blog = new Anchor("blog", "Blog");

    @Override
    public void afterNavigation(
            AfterNavigationEvent event) {
        boolean active = event.getLocation()
                .getFirstSegment()
                .equals(blog.getHref());
        blog.getElement()
                .getClassList()
                .set("active", active);
    }
}