package com.example.immigration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
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
<<<<<<< Updated upstream
    @OneToMany(mappedBy = "usersByUserId")
    @JsonIgnore
    private Collection<ImmigrationInformation> immigrationInformationsById;
    @OneToMany(mappedBy = "usersByUserId")
    @JsonIgnore
    private Collection<Identitycard> identitycardsById;
    @OneToMany(mappedBy = "usersByUserId")
    @JsonIgnore
    private Collection<License> licensesById;
    @OneToMany(mappedBy = "usersByUserId")
    @JsonIgnore
    private Collection<UserRoles> userRolesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
=======

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();
    public Users() {
    }
    public Users(String username, String email, String password) {
        this.username = username;
>>>>>>> Stashed changes
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (fullname != null ? !fullname.equals(users.fullname) : users.fullname != null) return false;
        if (gender != null ? !gender.equals(users.gender) : users.gender != null) return false;
        if (nationality != null ? !nationality.equals(users.nationality) : users.nationality != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(users.dateOfBirth) : users.dateOfBirth != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    public Collection<ImmigrationInformation> getImmigrationInformationsById() {
        return immigrationInformationsById;
    }

    public void setImmigrationInformationsById(Collection<ImmigrationInformation> immigrationInformationsById) {
        this.immigrationInformationsById = immigrationInformationsById;
    }

    public Collection<Identitycard> getIdentitycardsById() {
        return identitycardsById;
    }

    public void setIdentitycardsById(Collection<Identitycard> identitycardsById) {
        this.identitycardsById = identitycardsById;
    }

    public Collection<License> getLicensesById() {
        return licensesById;
    }

    public void setLicensesById(Collection<License> licensesById) {
        this.licensesById = licensesById;
    }

    public Collection<UserRoles> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRoles> userRolesById) {
        this.userRolesById = userRolesById;
    }
}
