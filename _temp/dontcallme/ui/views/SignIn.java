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
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.Validator;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@PageTitle("Sign-In to use service")
@Route(value = "signIn", layout = MainLayout.class)
public class SignIn extends ViewFrame {
    private TextField id;
    private PasswordField password;
    private EmailField email;
    private DatePicker birthDate;
    private Button submit;

    private Binder<User> binder = new Binder<>(User.class);
    private UserService userService;


    private final int MIN_LENGTH_ID = 6;
    private final int MAX_LENGTH_ID = 30;
    private final int MIN_LENGTH_PASSWORD = 8;
    private final int MAX_LENGTH_PASSWORD = 100;

    public SignIn(UserRepository userRepository) {
        setId("signIn");
        userService = UserService.getInstance(userRepository);

        initId();
        initPassword();
        initRestField();
        initButton();


        setViewContent(createContent());
    }

    private void initId() {
        id = new TextField("Id", "Length must be 6 ~ 100");
        id.setMinLength(MIN_LENGTH_ID);
        id.setMaxLength(MAX_LENGTH_ID);

        binder.forField(id)
                .withValidator((Validator<String>) (value, context) -> {
                    if (value.length() < MIN_LENGTH_ID || value.length() > MAX_LENGTH_ID) {
                        return ValidationResult
                                .error("Length must be 6 ~ 100");
                    }
                    if (!Character.isLetter(value.charAt(0))) {
                        return ValidationResult.error("First character must be a letter");
                    }
                    if (value.matches(".*\\s+.*")) {
                        return ValidationResult.error("White-space not allowed");
                    }
                    if (value.matches(".*\\W+.*")) {
                        return ValidationResult.error("Special characters only allowed: _");
                    }

                    return ValidationResult.ok();
                })
                .bind(User::getId, User::setId);
    }

    private void initPassword() {
        password = new PasswordField("Password", "Length must be 8 ~ 100");
        password.setMinLength(MIN_LENGTH_PASSWORD);
        password.setMaxLength(MAX_LENGTH_PASSWORD);

        binder.forField(password)
                .withValidator((Validator<String>) (value, context) -> {
                    if (value.length() < MIN_LENGTH_PASSWORD || value.length() > MAX_LENGTH_PASSWORD) {
                        return ValidationResult
                                .error("Length must be 8 ~ 100");
                    }
                    if (value.matches(".*\\s+.*")) {
                        return ValidationResult.error("White-space not allowed");
                    }
                    if (!value.matches(".*\\d+.*")) {
                        return ValidationResult.error("Number must be included");
                    }
                    if (!value.matches(".*[a-zA-Z]+.*")) {
                        return ValidationResult.error("Letter must be included");
                    }
                    if (!value.matches(".*\\W+.*")) {
                        return ValidationResult.error("Special character must be included except white-space");
                    }

                    return ValidationResult.ok();
                })
                .bind(User::getPasswordHash, User::setPasswordHash);
    }

    private void initRestField() {
        birthDate = new DatePicker("Birthdate");
        birthDate.setValue(LocalDate.now());
        birthDate.setClearButtonVisible(true);

        binder.forField(birthDate)
                .bind(User::getBirthDate, User::setBirthDate);

        email = new EmailField("Email", "email for authentication");
        binder.forField(email)
                .bind(User::getEmail, User::setEmail);
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
            dialog.setCloseOnEsc(false);
            dialog.setCloseOnOutsideClick(false);

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
            id.focus();
        }
    }


    private Component createContent() {
//        Binder<this> binder = new Binder<>(this);
        // validation like google Gmail


//        FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
//        links.setFlexWrap(FlexWrap.WRAP);
//        links.setSpacing(Right.S);

        FlexBoxLayout content = new FlexBoxLayout(id, password, email, birthDate, submit);
        content.setFlexDirection(FlexDirection.COLUMN);
        content.setMargin(Horizontal.AUTO);
        content.setMaxWidth("840px");
        content.setPadding(Uniform.RESPONSIVE_L);
        return content;
    }

}



/*
public class Home extends Div {
    public Home() {
        setText("Hello world");
    }
}
* */
/*
@PageTitle("Welcome")
@Route("")
@PWA(name = "dontcallme IoT SSS Project", shortName = "dontcallme", description = "IoT Streaming Security Solution")
public class Home extends VerticalLayout {

    public Home() {
        VerticalLayout todosList = new VerticalLayout(); // (1)
        TextField taskField = new TextField(); // (2)
        Button addButton = new Button("Add"); // (3)
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
// (4)
Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
                    });

                    ConfirmDialog dialog = new ConfirmDialog("Confirm delete",
                    "Are you sure you want to delete the item?",
                    "Delete", this::onDelete, "Cancel", this::onCancel);
                    dialog.setConfirmButtonTheme("error primary");
                    Button button = new Button("Open dialog");
                    button.addClickListener(event -> dialog.open());


        add( // (5)
        new H1("Vaadin Todo"),
        todosList,
        new HorizontalLayout(
        taskField,
        addButton
        ),
        button
        );
        }

        private void onCancel(ConfirmDialog.CancelEvent cancelEvent) {
        System.out.println("asdf");
        }

        private void onDelete(ConfirmDialog.ConfirmEvent confirmEvent) {
        System.out.println("asdf1");
        }
        }
*/
/*
public class Home {
    public Home () {
        TextField textField = new TextField();
        // Simple HTML inline text
        Span greeting = new Span("Hello stranger");

        textField.addValueChangeListener(event ->
                greeting.setText("Hello " + event.getValue()));

        VerticalLayout layout = new VerticalLayout(
                textField, greeting);
    }
}
* */


/*
@Route(value = "", layout = MainLayout.class)
public class Home extends VerticalLayout {

    public Home() {
        VerticalLayout todosList = new VerticalLayout(); // (1)
        TextField taskField = new TextField(); // (2)
        Button addButton = new Button("Add"); // (3)
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
// (4)
            Checkbox checkbox = new Checkbox(taskField.getValue());
            todosList.add(checkbox);
        });

        ConfirmDialog dialog = new ConfirmDialog("Confirm delete",
                "Are you sure you want to delete the item?",
                "Delete", this::onDelete, "Cancel", this::onCancel);
        dialog.setConfirmButtonTheme("error primary");
        Button button = new Button("Open dialog");
        button.addClickListener(event -> dialog.open());


        add( // (5)
                new H1("Vaadin Todo"),
                todosList,
                new HorizontalLayout(
                        taskField,
                        addButton
                ),
                button
        );
    }

    private void onCancel(ConfirmDialog.CancelEvent cancelEvent) {
        System.out.println("asdf");
    }

    private void onDelete(ConfirmDialog.ConfirmEvent confirmEvent) {
        System.out.println("asdf1");
    }
}
*/