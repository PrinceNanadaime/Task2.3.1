package web.model;

import javax.persistence.*;

@Entity
@Table(name = "UsersTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "lastName",nullable = false)
    private String lastName;
    @Column(name = "age",nullable = false)
    private byte age;

    public User(){

    }

    public User(String name, String lastName, byte age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}