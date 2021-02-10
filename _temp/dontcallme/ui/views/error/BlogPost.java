package com.practice.dontcallme.ui.views.error;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("blog-post")
public class BlogPost extends Div
        implements BeforeEnterObserver {
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!hasPermission()) {
            event.forwardTo(NoPermission.class);
        }
    }

    private boolean hasPermission() {
        // no-op implementation
        return false;
    }
}
