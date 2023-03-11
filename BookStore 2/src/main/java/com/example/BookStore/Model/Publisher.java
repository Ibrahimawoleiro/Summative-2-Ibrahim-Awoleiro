package com.example.BookStore.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="publisher")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publisher implements Serializable {
    @Id
    @Column(name="publisher_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int publisher_id;
    String name;

    String street;
    String city;

    //2 characters
    String state;
    String postal_code;
    String phone;
    String email;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="publisher_id")
    private Set<Book> Books = new HashSet<>();

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
