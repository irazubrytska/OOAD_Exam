package com.example.ooad_exam.service;

import com.example.ooad_exam.model.Subscription;
import com.example.ooad_exam.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public boolean addSubscription(Subscription subscription, String userId) {
        return true;
    }
}
