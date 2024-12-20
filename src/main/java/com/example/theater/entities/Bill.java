package com.example.theater.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalPrice;
    private String dateCreated;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ticket> tickets; // Một Bill có nhiều Ticket
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> foods; // Một Bill có nhiều Food

    public Bill(int totalPrice, String dateCreated, AppUser user, List<Ticket> tickets, List<Food> foods) {
        this.totalPrice = totalPrice;
        this.dateCreated = dateCreated;
        this.user = user;
        this.tickets = tickets;
        this.foods = foods;
    }
}