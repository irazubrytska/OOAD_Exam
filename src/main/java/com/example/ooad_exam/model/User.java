package com.example.ooad_exam.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    String id;
    String name;
    String surname;

    List<Card> cards;
    Subscription subscription;
    List<Invoice> invoices;
}
