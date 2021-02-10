package com.practice.dontcallme.ui.views;


import com.practice.dontcallme.ui.MainLayout;
import com.practice.dontcallme.ui.components.layout.FlexBoxLayout;
import com.practice.dontcallme.ui.layout.size.Horizontal;
import com.practice.dontcallme.ui.layout.size.Uniform;
import com.practice.dontcallme.ui.util.css.FlexDirection;
import com.practice.dontcallme.ui.components.frame.ViewFrame;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@CssImport("./styles/misc/image.css")
@PageTitle("IoT Streaming Security Solution")
@Route(value = "", layout = MainLayout.class)
public class Home extends ViewFrame {

    public Home() {
        setId("home");
        setViewContent(createContent());
    }

    private Component createContent() {
        Html intro = new Html("<p>IoT 기기는 보통 무선 통신을 통해 조작되는데 신뢰 가능한 메인 서버를 통하지 않은 이러한 통신은 쉽게 해커들에 의해 스니핑될 수 있고, IoT 기기의 배치 특성상 봇넷이 되어버릴 수 있다. " +
                "이를 위해 메인 서버가 필요하다는 가정하에 개발 및 배포를 단순화하고 다른 앱과의 원활한 연동을 위해 컨테이너 플랫폼인 Docker를 사용하도록 한다." +
                "<b>클라우드 계층을 제외한 3계층인 코드, 컨테이너, 클러스터 보안을 고려하여 시스템을 설계하였다.</b></p>");

        Image image = new Image("images/4c.png", "The 4C's of Cloud Native Security");
        image.setClassName("imgOne");

        Html backend = new Html("<p><br><b>Back-end: Spring framework with Spring Security</b></p>");

        Html frontend = new Html("<p><b>Front-end: Vaadin</b><br>" +
                "서버 사이드 기반 프레임워크로서 브라우저에 앱의 내부상태를 노출시키지 않는다. " +
                "또한, 데이터 위변조를 막기 위해 클라이언트단의 데이터 검증은 안전하지 않은 데이터 검증을 보완하여 서버단에서 데이터 검증을 할 수 있다.</p>");

//        Anchor documentation = new Anchor("https://vaadin.com/docs/business-app/overview.html", UIUtils.createButton("Read the documentation", VaadinIcon.EXTERNAL_LINK));
//        Anchor starter = new Anchor("https://vaadin.com/start/latest/business-app", UIUtils.createButton("Start a new project with Business App", VaadinIcon.EXTERNAL_LINK));
//
//        FlexBoxLayout links = new FlexBoxLayout(documentation, starter);
//        links.setFlexWrap(FlexWrap.WRAP);
//        links.setSpacing(Right.S);

        FlexBoxLayout content = new FlexBoxLayout(intro, image, backend, frontend);
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