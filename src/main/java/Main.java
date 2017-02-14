import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = UTIL.HibernateUtil.getSessionFactory().openSession();
        System.out.println("HUIZ");
        session.close();
        System.out.println("OK");
    }
}
