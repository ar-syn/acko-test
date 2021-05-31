package com.example.security.securityDemo.Team.Model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Team {

    @Id
    @GeneratedValue(generator = "CustomIdentifierGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

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
}
