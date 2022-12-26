package com.example.ooad_exam.service;

import com.example.ooad_exam.model.Subscription;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void pay(Subscription subscription) throws Exception {
        // actually tries to pay for a subscription
        // may throw exception if smth goes wrong
    }
}
