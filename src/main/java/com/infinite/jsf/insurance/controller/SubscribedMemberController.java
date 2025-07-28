package com.infinite.jsf.insurance.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.infinite.jsf.insurance.daoImpl.SubscribedMemberDaoImpl;
import com.infinite.jsf.insurance.model.SubscribedMember;

/**
 * JSF Managed Bean for searching subscribed members by Subscription ID
 * or by Recipient HID and Date of Birth.
 */
public class SubscribedMemberController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subscriptionId;
    private String hId;
    private String dobString; // format: yyyy-MM-dd
    private List<SubscribedMember> searchResults = new ArrayList<>();

    private SubscribedMemberDaoImpl subscribedMemberDao = new SubscribedMemberDaoImpl();

    public String searchSubscribedMembers() {
        FacesContext context = FacesContext.getCurrentInstance();
        searchResults.clear();

        // ✅ Validate input: Either subscriptionId or (hId + dob) required
        boolean isSubscriptionIdEmpty = (subscriptionId == null || subscriptionId.trim().isEmpty());
        boolean isHidEmpty = (hId == null || hId.trim().isEmpty());
        boolean isDobEmpty = (dobString == null || dobString.trim().isEmpty());

        if (isSubscriptionIdEmpty && (isHidEmpty || isDobEmpty)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Please enter either Subscription ID or both HID and Date of Birth.", null));
            return null;
        }

        try {
            Date dob = null;
            if (!isDobEmpty) {
                dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobString);
            }

            searchResults = subscribedMemberDao.searchBySubscriptionIdOrHidAndDob(subscriptionId, hId, dob);

            if (searchResults == null || searchResults.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "No subscribed members found for the given search criteria.", null));
            }

        } catch (ParseException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid date format. Please use yyyy-MM-dd.", null));
        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "An error occurred while searching. Please try again.", null));
        }

        return null; // stay on same page
    }

    // ✅ Getters and Setters

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
