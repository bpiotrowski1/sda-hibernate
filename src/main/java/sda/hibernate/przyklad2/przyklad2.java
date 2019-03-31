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
        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setImie("Robert");
        nowyUzytkownik.setNazwisko("persist");
        session.persist(nowyUzytkownik);
        session.flush();
        session.close();
            System.out.println("Dodano nowego uzytkownika, przy pomocy persist() o id=" + nowyUzytkownik.getId() + ", imie=" + nowyUzytkownik.getImie() + ", nazwisko=" + nowyUzytkownik.getNazwisko());
    }

    public static Uzytkownik useMerge(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik nowyUzytkownik = new Uzytkownik();
        nowyUzytkownik.setImie("Robert");
        nowyUzytkownik.setNazwisko("merge");
        nowyUzytkownik = (Uzytkownik) session.merge(nowyUzytkownik);
        session.flush();
        session.close();
        System.out.println("Dodano nowego uzytkownika, przy pomocy merge() o id=" + nowyUzytkownik.getId() + ", imie=" + nowyUzytkownik.getImie() + ", nazwisko=" + nowyUzytkownik.getNazwisko());
        return nowyUzytkownik;
    }
}
