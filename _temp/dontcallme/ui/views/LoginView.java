package com.practice.dontcallme.ui.views;


import com.practice.dontcallme.backend.User;
import com.practice.dontcallme.backend.UserRepository;
import com.practice.dontcallme.backend.UserService;
import com.practice.dontcallme.ui.MainLayout;
import com.practice.dontcallme.ui.components.frame.ViewFrame;
import com.practice.dontcallme.ui.components.layout.FlexBoxLayout;
import com.practice.dontcallme.ui.layout.size.Horizontal;
import com.practice.dontcallme.ui.layout.size.Uniform;
import com.practice.dontcallme.ui.util.css.FlexDirection;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@PageTitle("Log-In to use service")
@Route(value = "login", layout = MainLayout.class)
public class LoginView extends ViewFrame {
    private LoginForm loginForm;
    private Button submit;

    private Binder<User> binder = new Binder<>(User.class);
    private UserService userService;


    private final int MIN_LENGTH_ID = 6;
    private final int MAX_LENGTH_ID = 30;
    private final int MIN_LENGTH_PASSWORD = 8;
    private final int MAX_LENGTH_PASSWORD = 100;

    public LoginView(UserRepository userRepository) {
        setId("logIn");
        userService = UserService.getInstance(userRepository);

        initRestField();
        initButton();


        setViewContent(createContent());
    }
    private void initRestField() {
        loginForm = new LoginForm();
        LoginOverlay loginOverlay = new LoginOverlay();
    }

    private void initButton() {
        setUser(new User());

        submit = new Button("Submit", VaadinIcon.CHECK.create());
        submit.addClickListener(e -> {
            if (binder.validate().isOk()) {
                submit();
            }
        });
        submit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    }

    private void submit() {
        User user = binder.getBean();
        if(userService.save(user)) {
            Dialog dialog = new Dialog();
            dialog.setCloseOnEsc(true);
            dialog.setCloseOnOutsideClick(true);

            Button confirmButton = new Button(
                    "Success to create account, Go your email and confirm"
                    , new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT)
            );
            confirmButton.setIconAfterText(true);
            confirmButton.addClickListener(event -> {
                dialog.close();
                getUI().ifPresent(ui ->
                        ui.navigate(""));
            });

            dialog.add(confirmButton);
            dialog.open();
        }
    }

    private void setUser(User user) {
        binder.setBean(user);

        if (user == null) {
            setVisible(false);
        } else {
            setVisible(true);
//            id.focus();
        }
    }


    private Component createContent() {
//        Binder<this> binder = new Binder<>(this);
        // validation like google Gmail


//        FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
//        links.setFlexWrap(FlexWrap.WRAP);
//        links.setSpacing(Right.S);

        FlexBoxLayout content = new FlexBoxLayout(loginForm, submit);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

}