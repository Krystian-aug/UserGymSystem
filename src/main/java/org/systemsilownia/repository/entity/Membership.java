package org.systemsilownia.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "membership")
@Getter
@Setter
@NoArgsConstructor
public class Membership {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "membership_duration")
    private LocalDate membership_duration = LocalDate.now();
    @Column(name = "price")
    private double price = 100.00;
    @Column(name = "price")
    private boolean discount = false;

    public Membership(LocalDate membership_duration, boolean discount) {
        this.discount = discount;
        if(discount)
        {
            this.price = 100.00;
        }
        else{
            this.price = 150.00;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Double.compare(price, that.price) == 0 && discount == that.discount && Objects.equals(id, that.id) && Objects.equals(membership_duration, that.membership_duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership_duration, price, discount);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", membership_duration=" + membership_duration +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
