package ro.siit.Proiect.Final.Model;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


  @NotBlank
  @NotNull
  @Column(name = "firstname")
  @Size(min = 1, max = 20)
  private String firstname;


  @NotNull
  @NotBlank
  @Column(name = "lastname")
  @Size(min = 1, max = 20)
  private String lastname;


  @NotBlank
  @NotNull
  @Column(name = "adress")
  private String adress;


  @NotNull
  @NotBlank
  @Column(name = "city")
  private String city;


  @NotBlank
  @NotNull
  @Column (name = "password")
  private String password;

  @NotBlank
  @NotNull
  @Column(name = "username")
  private String username;


  @NotNull
  @Column(name = "phone")
  private String phone;

//    @Size (min=3, max=14)//mesage = "invalid")
//    private String role;

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}


