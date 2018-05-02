package com.pqtca.models;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue
    private long id;

    @Column(name= "user_name" ,nullable = false, unique = true, length = 45)
    private String userName;

    @Column(name ="first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name ="last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false)
    private int isAdmin;




    public User(long id, String userName, String firstName, String lastName, String email, String password, int isAdmin) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    User(User copy) {
        id = copy.id;
        email = copy.email;
        userName = copy.userName;
        password = copy.password;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
