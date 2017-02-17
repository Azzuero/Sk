import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout Principal_Page = new VerticalLayout();
        ComboBox combocrmd = new ComboBox("CRMD");
        ComboBox comboskill = new ComboBox("Skill");
        ComboBox comboAsignee = new ComboBox("Asignee CRMD");
        DateField dateSkill = new DateField();
        Principal_Page.addComponents(combocrmd, comboskill, comboAsignee, dateSkill);
        setContent(Principal_Page);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
