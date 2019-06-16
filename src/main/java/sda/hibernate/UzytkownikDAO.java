package sda.hibernate;

import org.hibernate.Session;
import sda.hibernate.entity.Uzytkownik;

public class UzytkownikDAO {
    public void insert(Uzytkownik uzytkownik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(uzytkownik);
        session.flush();
        session.close();
    }
    public Uzytkownik select(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik nowyUzytkownik = session.find(Uzytkownik.class,id); //nalezy podac id ktore jest w bazie, w przeciwnym razie bedzie NullPointerException
        session.flush();
        session.close();
        return nowyUzytkownik;

    }
    public  Uzytkownik update(Uzytkownik uzytkownik){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        uzytkownik = (Uzytkownik) session.merge(uzytkownik);
        session.flush();
        session.close();
        return uzytkownik;
    }

    public void delete(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik uzytkownikUsuwany = new Uzytkownik();
        uzytkownikUsuwany.setId(id);
        session.delete(session.contains(uzytkownikUsuwany)?uzytkownikUsuwany:session.merge(uzytkownikUsuwany));
        session.flush();
        session.close();
    }
}
