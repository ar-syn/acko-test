package com.example.security.securityDemo.User.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(generator = "CustomIdentifierGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String login;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserAuthorities> authorities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserAuthorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<UserAuthorities> authorities) {
        this.authorities = authorities;
    }
}
