package com.newt.models;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_tb")
public class User {

    public interface CreateUser{}
    public interface UpdateUser{}
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, updatable = false, nullable = false) 
    private UUID id;

    @Column(name = "username", unique = true, updatable = false, nullable = false, length = 100)
    @NotNull(groups = CreateUser.class)
    @NotBlank(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 10, max = 100)
    private String username;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", unique = true, updatable = true, nullable = false, length = 100)
    @NotNull(groups = {CreateUser.class, UpdateUser.class})
    @NotBlank(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 10, max = 100)
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public User(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 

    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User otherUser = (User) obj;
        if (this.id == null)
            if (otherUser.id != null)
                return false;
            else if (!this.id.equals(otherUser.id))
                return false;
        return Objects.equals(this.id, otherUser.id) && Objects.equals(this.username, otherUser.username) && Objects.equals(this.password, otherUser.password);
    }

}
