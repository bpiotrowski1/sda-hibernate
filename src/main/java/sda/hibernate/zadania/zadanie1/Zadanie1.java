package sda.hibernate.zadania.zadanie1;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

import java.util.List;

public class Zadanie1 {
    void insert(Uzytkownik uzytkownik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(uzytkownik);
        session.flush();
        session.close();
    }

    Uzytkownik select(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik uzytkownik = session.find(Uzytkownik.class, id);
        session.flush();
        session.close();
        return uzytkownik;
    }

    Uzytkownik update(Uzytkownik uzytkownik) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        uzytkownik = (Uzytkownik) session.merge(uzytkownik);
        session.flush();
        session.close();
        return uzytkownik;
    }

    void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik doUsuniecia = new Uzytkownik();
        doUsuniecia.setId(id);
        session.delete(session.contains(doUsuniecia)?doUsuniecia:session.merge(doUsuniecia));
        session.flush();
        session.close();
    }

    Long getLastId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT max(id) FROM Uzytkownik");
        List results = query.list();
        return (Long) results.get(0);
    }

    Long getFirstId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT min(id) FROM Uzytkownik");
        List results = query.list();
        return (Long) results.get(0);
    }
}
