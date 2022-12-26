package com.example.ooad_exam.service;

import com.example.ooad_exam.model.SubscriptionRequest;
import com.example.ooad_exam.model.enums.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionRequestService {
    @Autowired
    PaymentService paymentService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    TaskSchedulerService taskScheduler;

    public void handle(SubscriptionRequest request) {
        // try to pay for a new  created subscription
        try {
            paymentService.pay(request.getSubscription());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // if success - subscription is added for a user
        subscriptionService.addSubscription(request.getSubscription(), request.getUser().getId());

        // and will be scheduled for automatic payments
        if(request.getSubscription().getPaymentType().equals(PaymentType.AUTOMATIC)) {
            taskScheduler.scheduleAutoPayments(request.getUser());
        }
    }
}
