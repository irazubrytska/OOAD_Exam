package com.example.ooad_exam.model;

import com.example.ooad_exam.model.enums.PaymentType;
import com.example.ooad_exam.model.enums.Period;
import lombok.Data;

import java.util.Date;

@Data
public class Subscription {
    Tariff tariff;
    Period period;
    PaymentType paymentType;
    Card card; // only for automatic payment type
    Date startDate;
    boolean active;
}
