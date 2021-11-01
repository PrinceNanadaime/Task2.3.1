package web.model;

import javax.persistence.*;

@Entity
@Table(name = "UsersTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "lastName",nullable = false)
    private String lastname;
    @Column(name = "age",nullable = false)
    private byte age;

    public User(){

    }

    public User(String name, String lastName, byte age){
        this.name = name;
        this.lastname = lastName;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "User " + getName() + " " + getLastname() + " " + getAge() + " y.o.";
    }
}