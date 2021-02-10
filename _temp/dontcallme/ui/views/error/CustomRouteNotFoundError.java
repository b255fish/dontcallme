package com.practice.dontcallme.ui.views.error;

import com.practice.dontcallme.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.*;

import javax.servlet.http.HttpServletResponse;

@ParentLayout(MainLayout.class)
@PageTitle("TITLE_NOT_FOUND")
public class CustomRouteNotFoundError extends RouteNotFoundError {

	public CustomRouteNotFoundError() {
		RouterLink link = Component.from(
				ElementFactory.createRouterLink("", "Go to the front page."),
				RouterLink.class);
		getElement().appendChild(new Text("Oops you hit a 404. ").getElement(), link.getElement());
	}

	@Override
	public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
//		getElement().setText(
//				"My custom not found class!");

		return HttpServletResponse.SC_NOT_FOUND;
	}
}
