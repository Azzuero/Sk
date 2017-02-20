import Entity.Employee;
import Util.Crud;
import Util.HibernateUtil;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;

import javax.servlet.annotation.WebServlet;
import java.util.List;



/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

//com
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createCriteria(Employee.class).list();
        VerticalLayout Principal_Page = new VerticalLayout();
        //cpp
        ComboBox comboAsignee = new ComboBox("Asignee CRMD");
        DateField dateSkill = new DateField();
        ComboBox Employee = Crud.getEmployee();
        Employee.addValueChangeListener(e -> {
            comboAsignee.removeAllItems();
            for (Employee next : Crud.getAssignee(String.valueOf(e.getProperty().getValue())))
                comboAsignee.addItems(next.getCrmd());

        });
        ComboBox comboBox = new ComboBox("SKILLLLLLL");
        //comboBox.addItems(Crud.getSkill1());
        Principal_Page.addComponents(Employee, Crud.getSkill(), comboAsignee, dateSkill, comboBox);
        Principal_Page.setMargin(true);
        Principal_Page.setSpacing(true);
        session.close();
        setContent(Principal_Page);
        Crud.getSkills();
    }



    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
