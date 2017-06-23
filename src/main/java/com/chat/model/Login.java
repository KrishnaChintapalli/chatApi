package com.chat.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sivaramakrishnaprasadchintapalli on 6/17/17.
 */
@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    @Column(name = "user_name",unique = true)
    private String userName;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    private String password;

    private boolean active=true;

    private Date created;

    private Date updated;
    private String token;

    @NotNull
    @Transient
    private String f_name;
    @NotNull
    @Transient
    private String l_name;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Role roles;

    public Login(){

    }
    public Login(String userName, String email, String password, String f_name, String l_name, Role roles){
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.f_name = f_name;
        this.l_name = l_name;
        this.roles = roles;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        user.setLogin(this);
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", created=" + created +
                ", updated=" + updated +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                '}';
    }
}
