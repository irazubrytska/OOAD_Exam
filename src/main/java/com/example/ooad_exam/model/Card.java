package com.example.ooad_exam.model;

import lombok.Data;

import java.util.Date;

@Data
public class Card {
    int number;
    int cvv;
    Date expireDate;

    User owner;
}
