package AutoVaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {


    protected static boolean session1 = false;

    public static void setSession() {
        session1 = false;
    }

    public void initLogin() {

        final VerticalLayout layout = new VerticalLayout();
        final TextField name = new TextField();
        name.setCaption("Username");
        final PasswordField pass = new PasswordField();
        pass.setCaption("Password");
        final Label label = new Label("");
        Button button = new Button();
        button.setCaption("Login");
        Button button1 = new Button("Inregistrare");
        button1.addClickListener(e -> addWindow(Function.inregform()));
        button.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        button.addClickListener(e -> {
            if (Function.check(name.getValue(), pass.getValue()) == true) {
                setContent(Function.Init());
                session1 = true;
            } else {
                label.setCaption("Wrong Data!");
            }
        });
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponents(button, button1);
        horizontalLayout.setSpacing(true);
        layout.addComponents(label, name, pass, horizontalLayout);
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        if (session1 != false) {
            setContent(Function.Init());
        } else
            initLogin();

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
