package com.practice.dontcallme.ui.views.error;


import com.practice.dontcallme.ui.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.*;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.http.HttpServletResponse;

@Tag("access-denied-view")
@ParentLayout(MainLayout.class)
@PageTitle("TITLE_ACCESS_DENIED")
@Route
public class AccessDeniedView extends PolymerTemplate<TemplateModel> implements HasErrorParameter<AccessDeniedException> {

	@Override
	public int setErrorParameter(BeforeEnterEvent beforeEnterEvent, ErrorParameter<AccessDeniedException> errorParameter) {
		return HttpServletResponse.SC_FORBIDDEN;
	}
}


// @JsModule("./src/views/errors/access-denied-view.js")
// @PageTitle(Const.TITLE_ACCESS_DENIED)