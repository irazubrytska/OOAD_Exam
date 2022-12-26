package com.example.ooad_exam.service;

import com.example.ooad_exam.model.Invoice;
import com.example.ooad_exam.model.User;
import com.example.ooad_exam.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice generate(User user) {
        // generating invoice for a specific user
        // and adding it to DB
        return new Invoice();
    }
}
