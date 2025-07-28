package com.infinite.jsf.insurance.controller;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.model.Recipient;
import com.infinite.jsf.util.RecipientIdGenerator;
import com.infinite.jsf.util.SessionHelper;

public class RecipientController implements Serializable {

    private Recipient recipient = new Recipient();

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public String saveRecipient() {
        Session session = SessionHelper.getSessionFactory().openSession(); 
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Generate custom hId
            String newId = RecipientIdGenerator.getNextRecipientId(session);
            recipient.sethId(newId);

            session.save(recipient);
            tx.commit();

            System.out.println(" Recipient saved: " + newId);
            return "success";  // Ensure navigation rule for 'success' exists in faces-config
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "error";  // Navigation to error page
        } finally {
            session.close();
        }
    }
}