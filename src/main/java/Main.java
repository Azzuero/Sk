import TRAINING.EMPLOYEE;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = UTIL.HibernateUtil.getSessionFactory().openSession();
        List<EMPLOYEE> list = session.createQuery("from EMPLOYEE").list();
        for (EMPLOYEE next:list
             ) {
            System.out.println(next.getCrmd());
            System.out.println("---");

        }session.close();
    }
}
