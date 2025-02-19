package org.systemsilownia.repository.entity;

import java.util.Objects;

public class Client {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private double amount = 0.0;
    private String password;
    private Long membership_id = null;

    public Client(String firstname, String lastname, String email, String password){
        this.name = firstname;
        this.surname = lastname;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public double getAmount() {
        return amount;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(Long membership_id) {
        this.membership_id = membership_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(amount, client.amount) == 0 && Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(surname, client.surname) && Objects.equals(email, client.email) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, amount, password);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", amount=" + amount +
                ", password='" + password + '\'' +
                '}';
    }
}
