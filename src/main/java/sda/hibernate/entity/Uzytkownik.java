package sda.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(schema = "ksiegarnia", name = "uzytkownik")
public class Uzytkownik {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private long id;
  @Column
  private String imie;
  @Column
  private String nazwisko;

  public Uzytkownik() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }


  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }

}
