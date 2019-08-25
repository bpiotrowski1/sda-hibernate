/*
 * przyklad2 hibernate
 * przyklad stosowania persist()-zawsze tworzy nowy obiekt i merge()- aktualizuje lub dodaje nowy obiekt obiektu Session*/

package sda.hibernate.przyklad2;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad2 {
    public static void main(String[] arg) {
        usePersist();
        useMerge();
    }

    public static void usePersist(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik nowyUzytkownik = new Uzytkownik("Robert", "persist");
        session.persist(nowyUzytkownik);
        session.flush();
        System.out.println(nowyUzytkownik.getId());
        session.close();
        System.out.println("Dodano nowego uzytkownika, przy pomocy persist(): " + nowyUzytkownik);
    }

    public static Uzytkownik useMerge(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik nowyUzytkownik = new Uzytkownik("Robert", "merge");
        nowyUzytkownik = (Uzytkownik) session.merge(nowyUzytkownik);
        session.flush();
        System.out.println(nowyUzytkownik.getId());
        session.close();
        System.out.println("Dodano nowego uzytkownika, przy pomocy merge(): " + nowyUzytkownik);
        return nowyUzytkownik;
    }
}
