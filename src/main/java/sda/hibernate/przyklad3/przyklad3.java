/*
 * przyklad3 hibernate
 * przyklad stosowania delete() obiektu Session, czyli usuwanie danych*/
package sda.hibernate.przyklad3;

import org.hibernate.Session;
import sda.hibernate.HibernateUtil;
import sda.hibernate.entity.Uzytkownik;

public class przyklad3 {

    public static void main(String[] arg) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Uzytkownik uzytkownikUsuwany = new Uzytkownik();
        uzytkownikUsuwany.setId(23L);//nalezy podac id ktore jest w bazie, w przeciwnym razie dostaniemy blad
        //aby tego uniknac, mozna zastosowac ponizsza linie
        //session.delete(session.contains(uzytkownikUsuwany)?uzytkownikUsuwany:session.merge(uzytkownikUsuwany))
        session.delete(uzytkownikUsuwany);
        session.flush();
        session.close();
    }
}
