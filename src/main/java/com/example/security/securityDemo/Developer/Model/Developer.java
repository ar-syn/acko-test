package com.example.security.securityDemo.Developer.Model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Developer {

    @Id
    @GeneratedValue(generator = "CustomIdentifierGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String phoneNumber;

    @Column(name = "team_id", columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID teamId;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }
}
