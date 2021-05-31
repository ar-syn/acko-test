package com.example.security.securityDemo.User.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "user_authorities")
public class UserAuthorities {

    @Id
    @GeneratedValue(generator = "CustomIdentifierGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne
    private User user;

    private String authority;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
