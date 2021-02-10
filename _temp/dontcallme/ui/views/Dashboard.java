package com.practice.dontcallme.ui.views;

import com.practice.dontcallme.ui.MainLayout;
import com.practice.dontcallme.ui.components.layout.FlexBoxLayout;
import com.practice.dontcallme.ui.layout.size.Horizontal;
import com.practice.dontcallme.ui.layout.size.Uniform;
import com.practice.dontcallme.ui.util.css.FlexDirection;
import com.practice.dontcallme.ui.components.frame.ViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/misc/image.css")
@PageTitle("My Camera Management")
@Route(value = "dashboard", layout = MainLayout.class)
public class Dashboard extends ViewFrame {
    private Image[] image = new Image[4];

    public Dashboard() {
        setId("dashboard");
        setViewContent(createContent());
    }

    private Component createContent() {
        HorizontalLayout layout1 = new HorizontalLayout();
        HorizontalLayout layout2 = new HorizontalLayout();

        for (int i = 0; i < image.length; i++){
            image[i] = new Image("images/newPage.png", ("Camera screen" + (i+1)));
            image[i].setClassName("imgOne");
            image[i].setTitle("Your Camera" + (i+1));
        }

        layout1.setWidth("100%");
        layout2.setWidth("100%");
        layout1.setMargin(true);
        layout1.setPadding(true);
        layout2.setMargin(true);
        layout2.setPadding(true);

        layout1.add(image[0], image[1]);
        layout2.add(image[2], image[3]);


        FlexBoxLayout content = new FlexBoxLayout(layout1, layout2);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("1080px");
        content.setPadding(Uniform.RESPONSIVE_L);

        return content;
    }
}




/*
public class Dashboard extends VerticalLayout {

    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);
    private TextField filterText = new TextField();
    private CustomerForm form = new CustomerForm(this);

    public Dashboard() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText,
                addCustomerBtn);

        grid.setColumns("firstName", "lastName", "status");

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);

        setSizeFull();

        updateList();
        form.setCustomer(null);

        grid.asSingleSelect().addValueChangeListener(event ->
                form.setCustomer(grid.asSingleSelect().getValue()));
    }

    public void updateList() {
        grid.setItems(service.findAll(filterText.getValue()));
    }

}

* */