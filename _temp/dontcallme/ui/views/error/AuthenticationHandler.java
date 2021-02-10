package com.practice.dontcallme.ui.views.error;

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import org.springframework.security.access.AccessDeniedException;

public class AuthenticationHandler
        implements BeforeEnterObserver {
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Class<?> target = event.getNavigationTarget();
        if (!currentUserMayEnter(target)) {
            event.rerouteToError(
                    AccessDeniedException.class);
        }
    }

    private boolean currentUserMayEnter(
            Class<?> target) {
        // implementation omitted
        return false;
    }
}
