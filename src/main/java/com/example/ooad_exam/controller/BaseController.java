package com.example.ooad_exam.controller;

import com.example.ooad_exam.model.Card;
import com.example.ooad_exam.model.Subscription;
import com.example.ooad_exam.model.SubscriptionRequest;
import com.example.ooad_exam.service.PaymentService;
import com.example.ooad_exam.service.SubscriptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/somepath")
public class BaseController {
    @Autowired
    private SubscriptionRequestService service;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = {"/subscribe"})
    public void subscribe(@ModelAttribute SubscriptionRequest request) {
        // process a subscription request
        service.handle(request);
    }

    @PostMapping(path = {"/pay/{invoiceId}"})
    public void payManually(@PathVariable String invoiceId, @ModelAttribute Subscription subscription) {
        // try pay for an invoice
        try {
            paymentService.pay(subscription);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
