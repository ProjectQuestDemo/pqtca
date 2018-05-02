package com.pqtca.demo.models;
import javax.persistence.*;


//CREATE TABLE IF NOT EXISTS `mydb`.`users` (
//        `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, X
//        `username` VARCHAR(45) NOT NULL, X
//        `first_name` VARCHAR(45) NOT NULL COMMENT '	X	',
//        `last_name` VARCHAR(45) NOT NULL, X
//        `email` VARCHAR(255) NOT NULL, X
//        `password` VARCHAR(20) NOT NULL,
//        `is_admin` TINYINT UNSIGNED NOT NULL DEFAULT 0,
//        PRIMARY KEY (`id`),
//        UNIQUE INDEX `emp_id_UNIQUE` (`id` ASC),
//        UNIQUE INDEX `username_UNIQUE` (`username` ASC),
//        UNIQUE INDEX `email_UNIQUE` (`email` ASC))
//        ENGINE = InnoDB



@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue
    private long id;

    @Column(name= "user_name" ,nullable = false, unique = true, length = 45)
    private String username;

    @Column(name ="first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name ="last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin;



    public User(User copy) {
        id = copy.id;
        username = copy.username;
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        password = copy.password;
        isAdmin = copy.isAdmin;
    }


    public User(long id, String username, String firstName, String lastName, String email, String password, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
