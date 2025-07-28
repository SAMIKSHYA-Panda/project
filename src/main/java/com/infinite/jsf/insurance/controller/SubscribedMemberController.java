package com.infinite.jsf.insurance.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.daoImpl.SubscribedMemberDaoImpl;
import com.infinite.jsf.insurance.model.SubscribedMember;

/**
 * SubscribedMemberController.java
 *
 * This JSF Managed Bean handles search functionality for Subscribed Members 
 * based on Subscription ID, Recipient HID, and Date of Birth.
 */
public class SubscribedMemberController implements Serializable {

    private String subscriptionId;
    private String hId;
    private String dobString;  // yyyy-MM-dd format
    private List<SubscribedMember> searchResults;

    // DAO
    private SubscribedMemberDaoImpl subscribedMemberDao = new SubscribedMemberDaoImpl();

    // Action method
    public String searchSubscribedMembers() {
        FacesContext context = FacesContext.getCurrentInstance();
        searchResults = new ArrayList<>();

        // Validation: Either subscriptionId or (hId and dob) must be provided
        if ((subscriptionId == null || subscriptionId.trim().isEmpty())
                && ((hId == null || hId.trim().isEmpty()) || (dobString == null || dobString.trim().isEmpty()))) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Please provide either Subscription ID or both HID and Date of Birth.", null));
            return null;
        }

        try {
            Date dob = null;
            if (dobString != null && !dobString.trim().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                dob = sdf.parse(dobString);
            }

            searchResults = subscribedMemberDao.searchBySubscriptionIdOrHidAndDob(subscriptionId, hId, dob);

            if (searchResults == null || searchResults.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "No subscribed members found for the given criteria.", null));
            }

        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid Date format. Please use yyyy-MM-dd.", null));
        }

        return null; // Stay on the same page
    }

    // --- Getters and Setters ---
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String gethId() {
        return hId;
    }

    public void sethId(String hId) {
        this.hId = hId;
    }

    public String getDobString() {
        return dobString;
    }

    public void setDobString(String dobString) {
        this.dobString = dobString;
    }

    public List<SubscribedMember> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<SubscribedMember> searchResults) {
        this.searchResults = searchResults;
    }
}