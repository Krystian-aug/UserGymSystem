package org.systemsilownia.repository.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="surname")
    private String surname;
    @Column(name ="email")
    private String email;
    @Column(name ="amount")
    private double amount = 0.0;
    @Column(name ="password")
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Membership membership = null;

    public Client(String firstname, String lastname, String email, String password){
        this.name = firstname;
        this.surname = lastname;
        this.email = email;
        this.password = password;
    }

    public Client(Long id, String name, String surname, String email, double amount, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.amount = amount;
        this.password = password;
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
