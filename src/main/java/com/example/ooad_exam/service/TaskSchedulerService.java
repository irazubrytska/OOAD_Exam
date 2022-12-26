package com.example.ooad_exam.service;

import com.example.ooad_exam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedulerService {
    @Autowired
    PaymentService paymentService;

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    InvoiceService invoiceService;

    // for each user generates invoices periodically
    // based on subscription start date and period
    // and tries to pay for it
    @Scheduled
    public void scheduleAutoPayments(User user) {
        // generates invoice
        invoiceService.generate(user);

        try { // tries to pay
            paymentService.pay(user.getSubscription());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // if payment is failed, then invoice 'paid' field is set to false
    }

    // every 24 hours tries to pay for unpaid invoices
    // if invoice is being paid for n-th time(e.g. 5th) and still fails
    // subscription will be blocked('active' field set to false)
    @Scheduled
    public void scheduleCheckUnpaidInvoices() {

    }
}
