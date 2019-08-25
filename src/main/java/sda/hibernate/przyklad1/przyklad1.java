/*
* przyklad1 hibernate
* przyklad stosowania find() obiektu Session, czyli szukanie danych*/

package sda.hibernate.przyklad1;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad1 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik nowyUzytkownik = session.find(Uzytkownik.class,39L); //nalezy podac id ktore jest w bazie, w przeciwnym razie bedzie NullPointerException
        session.flush();
        session.close();
        System.out.println("Pobrano uzytkownika: " + nowyUzytkownik);
    }
}
