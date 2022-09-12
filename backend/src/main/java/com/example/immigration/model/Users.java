package com.example.immigration.model;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String email;

    private String password;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "gender")
    private Integer gender;
    @Basic
    @Column(name = "nationality")
    private String nationality;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();
    public Users() {
    }
    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}

