package sda.hibernate.zadania.zadanie1;

import sda.hibernate.entity.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Zadanie1 zadanie1 = new Zadanie1();

        //1
        List<Uzytkownik> uzytkownicy = new ArrayList<>();
        uzytkownicy.add(new Uzytkownik("Imie1","Nazwisko1"));
        uzytkownicy.add(new Uzytkownik("Imie2","Nazwisko2"));
        uzytkownicy.add(new Uzytkownik("Imie3","Nazwisko3"));
        uzytkownicy.add(new Uzytkownik("Imie4","Nazwisko4"));
        uzytkownicy.add(new Uzytkownik("Imie5","Nazwisko5"));

        //2
        for (Uzytkownik uzytkownik : uzytkownicy) {
            zadanie1.insert(uzytkownik);
        }

        //3
        for (Uzytkownik uzytkownik: uzytkownicy) {
            uzytkownik.setNazwisko(uzytkownik.getImie() + " " + uzytkownik.getNazwisko());
            zadanie1.update(uzytkownik);
        }

        //4
        zadanie1.delete(zadanie1.getLastId());
        zadanie1.delete(zadanie1.getFirstId());
    }
}
