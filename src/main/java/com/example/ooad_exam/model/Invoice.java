package com.example.ooad_exam.model;

import lombok.Data;

import java.util.Date;

@Data
public class Invoice {
    String id;
    User user;                  // user
    Subscription subscription;  // user's subscription
    Tariff tariff; // amount of money to be paid
    Date date;  // date of invoice creation
    boolean paid;
}
