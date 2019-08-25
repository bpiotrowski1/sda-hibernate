package sda.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "ksiegarnia", name = "uzytkownik")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Getter @Setter
    private long id;
    @Column
    @Getter @Setter
    private String imie;
    @Column
    @Getter @Setter
    private String nazwisko;

    public Uzytkownik() {
    }

    public Uzytkownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
