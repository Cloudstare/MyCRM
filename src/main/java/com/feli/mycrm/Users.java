package com.feli.mycrm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String login;
    private String password;
    private int isDeleted;

    public Users(){}

    public Users(String name, String surname, String dateOfBirth, String login, String password, int isDeleted){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = new DateParser().getDate(dateOfBirth);
        this.login = login;
        this.password = password;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {return dateOfBirth;}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

}
