
package com.infinite.jsf.insurance.daoImpl;

import java.util.Date;

import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
import com.infinite.jsf.insurance.model.SubscribedMember;

public class Main {
    public static void main(String[] args) {
        // Create a new SubscribedMember object
        SubscribedMember subscribedMember = new SubscribedMember();
        subscribedMember.setMemberId("M0011"); // Ideally this should be auto-generated
        subscribedMember.setSubscriptionId("S001"); // Example subscription ID
        subscribedMember.sethId("R001"); 
        subscribedMember.setFullName("John Doe");
        subscribedMember.setDob(new Date()); // Set current date as DOB for testing
        subscribedMember.setAge(30);
        subscribedMember.setGender("Male");
        subscribedMember.setRelationWithProposer("Self");
        subscribedMember.setAadharNo("123456789012");
       
        

        // You may need to set Subscription if it's a required field in DB

        // Create DAO instance and add member
        SubscribedMemberDao dao = new SubscribedMemberDaoImpl();
        try {
            dao.addSubscribedMember(subscribedMember);
            System.out.println("Subscribed member added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding subscribed member: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
