package sda.hibernate;

import sda.hibernate.entity.Uzytkownik;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] arg) {
        List<Uzytkownik> listaUzytkownikow = new ArrayList<Uzytkownik>();
        listaUzytkownikow.add(new Uzytkownik("user1","nazwisko1"));
        listaUzytkownikow.add(new Uzytkownik("user2","nazwisko2"));
        listaUzytkownikow.add(new Uzytkownik("user3","nazwisko3"));
        listaUzytkownikow.add(new Uzytkownik("user4","nazwisko4"));
        listaUzytkownikow.add(new Uzytkownik("user5","nazwisko5"));

        UzytkownikDAO uzytkownikDAO=new UzytkownikDAO();
        for(Uzytkownik dozapisu:listaUzytkownikow){
            uzytkownikDAO.insert(dozapisu);
        }

        for(Uzytkownik dozapisu:listaUzytkownikow){
            dozapisu.setNazwisko(dozapisu.getImie()+" "+dozapisu.getNazwisko());
            uzytkownikDAO.update(dozapisu);
        }

        uzytkownikDAO.delete(listaUzytkownikow.get(0).getId());
        uzytkownikDAO.delete(listaUzytkownikow.get(4).getId());
    }
}
