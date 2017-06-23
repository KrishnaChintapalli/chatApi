package com.chat.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */

@Entity
@Table(name = "user_details")
public class User {

//    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "login"))
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "first_name")
    private String f_name;

    @NotNull
    @Column(name = "last_name")
    private String l_name;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private Date dob;
    private Date created;
    private Date updaetd;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    @MapsId
    private Login login;

    public User(){}

    public User(String f_name, String l_name) {
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdaetd() {
        return updaetd;
    }

    public void setUpdaetd(Date updaetd) {
        this.updaetd = updaetd;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", dob=" + dob +
                ", created=" + created +
                ", updaetd=" + updaetd +
                ", login=" + login +
                '}';
    }
}
