package org.example.taskmanager.entity;

import jakarta.persistence.*;
import org.example.taskmanager.model.Address;
import org.example.taskmanager.model.Role;

import java.util.Collection;

@Entity
@Table(name = "users" )
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String Lastname;
    @Embedded
    @Column(nullable = false)
    private Address address;
    @OneToMany(mappedBy = "users")
    private Collection<Task> task;

    private Role role ;

    public Users(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Collection<Task> getTask() {
        return task;
    }

    public void setTask(Collection<Task> task) {
        this.task = task;
    }




}
