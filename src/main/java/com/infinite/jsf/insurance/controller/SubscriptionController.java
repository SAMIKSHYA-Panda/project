package com.infinite.jsf.insurance.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import com.infinite.jsf.insurance.dao.*;
import com.infinite.jsf.insurance.daoImpl.*;
import com.infinite.jsf.insurance.model.*;
import com.infinite.jsf.util.SessionHelper;
import com.infinite.jsf.insurance.model.SubscriptionStatus;

public class SubscriptionController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Subscription subscription = new Subscription();
    private Recipient recipient = new Recipient();

    private List<Subscription> subscriptionList;
    private SubscriptionDao subscriptionDao = new SubscriptionDaoImpl();
    private InsurancePlanDao insurancePlanDao = new InsurancePlanDaoImpl();
    private InsuranceCoverageOptionDao coverageDao = new InsuranceCoverageOptionDaoImpl();

    private List<InsurancePlan> planList;
    private InsurancePlan selectedPlan;

    private InsuranceCoverageOption insuranceCoverageOption;
    private List<InsuranceCoverageOption> coverageOptions;
    private String selectedCoverageId;

    // === Sorting Support ===
    private String sortBy = "subscriptionId";
    private boolean ascending = true;

    // ================== GETTERS & SETTERS ==================

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public List<Subscription> getSubscriptionList() {
        if (subscriptionList == null) {
            subscriptionList = subscriptionDao.getAllSubscriptionsSorted(sortBy, ascending);
        }
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public InsurancePlan getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(InsurancePlan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }

    public List<InsurancePlan> getPlanList() {
        if (planList == null) {
            planList = insurancePlanDao.showAllPlans();
        }
        return planList;
    }

    public void setPlanList(List<InsurancePlan> planList) {
        this.planList = planList;
    }

    public InsuranceCoverageOption getInsuranceCoverageOption() {
        return insuranceCoverageOption;
    }

    public void setInsuranceCoverageOption(InsuranceCoverageOption insuranceCoverageOption) {
        this.insuranceCoverageOption = insuranceCoverageOption;
    }

    public List<InsuranceCoverageOption> getCoverageOptions() {
        if (coverageOptions == null && selectedPlan != null) {
            coverageOptions = coverageDao.getOptionsByPlanId(selectedPlan.getPlanId());
        }
        return coverageOptions;
    }

    public void setCoverageOptions(List<InsuranceCoverageOption> coverageOptions) {
        this.coverageOptions = coverageOptions;
    }

    public String getSelectedCoverageId() {
        return selectedCoverageId;
    }

    public void setSelectedCoverageId(String selectedCoverageId) {
        this.selectedCoverageId = selectedCoverageId;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    // ================== NAVIGATION ==================

    public String navigateToPlans() {
        return "SExplorePlans";
    }

    public String prepareSubscriptionPage(InsurancePlan plan) {
        this.selectedPlan = plan;
        this.coverageOptions = coverageDao.getOptionsByPlanId(plan.getPlanId());
        this.recipient = new Recipient();
        return "Subscribe";
    }

    // ================== BUSINESS LOGIC ==================

    public void fetchRecipientDetails() {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Recipient existing = (Recipient) session.get(Recipient.class, recipient.gethId());
            session.close();

            if (existing != null) {
                this.recipient = existing;
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Recipient not found!", null));
                this.recipient = new Recipient();
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error fetching recipient!", null));
        }
    }

    public String saveSubscription() {
        try {
            if (selectedCoverageId == null || selectedCoverageId.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please select a coverage option.", null));
                return null;
            }

            Session session = SessionHelper.getSessionFactory().openSession();
            Recipient existingRecipient = (Recipient) session.get(Recipient.class, recipient.gethId());
            session.close();

            if (existingRecipient == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Recipient not found in system!", null));
                return null;
            }

            subscription.setSubscriptionId(subscriptionDao.generateNextSubscriptionId());
            subscription.setRecipient(existingRecipient);

            InsuranceCoverageOption selectedOption = coverageDao.findByCoverageId(selectedCoverageId);
            subscription.setInsurancecoverageOption(selectedOption);
            subscription.setTotalPremium(selectedOption.getPremiumAmount());
            subscription.setAmountPaid(0.0);
            subscription.setSubscribeDate(new java.sql.Date(System.currentTimeMillis()));
            subscription.setExpiryDate(new java.sql.Date(System.currentTimeMillis() + 365L * 24 * 60 * 60 * 1000)); // +1 year
            subscription.setStatus("Active");

            subscriptionDao.addSubscription(subscription);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Subscription saved successfully!"));

            subscription = new Subscription();
            recipient = new Recipient();
            selectedCoverageId = null;
            subscriptionList = null;

            return "SubscriptionList?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while saving subscription.", null));
            return null;
        }
    }

    // ================== CRUD SUPPORT ==================

    public String editSubscription(Subscription sub) {
        this.subscription = sub;
        this.recipient = sub.getRecipient();
        return "subscription-form";
    }

    public String deleteSubscription(Subscription sub) {
        subscriptionDao.deleteSubscription(sub.getSubscriptionId());
        subscriptionList = null;
        return "SubscriptionList?faces-redirect=true";
    }

    public String renewSubscription(String subscriptionId) {
        try {
            Subscription sub = subscriptionDao.getSubscriptionById(subscriptionId);
            if (sub != null) {
                java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
                sub.setSubscribeDate(today);

                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(today);
                cal.add(java.util.Calendar.YEAR, 1);
                java.sql.Date newExpiry = new java.sql.Date(cal.getTimeInMillis());
                sub.setExpiryDate(newExpiry);

                sub.setStatus("Active");
                sub.setAmountPaid(0.0);

                subscriptionDao.updateSubscription(sub);

                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Subscription renewed successfully!"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error during renewal!", null));
        }

        subscriptionList = null;
        return "SubscriptionList?faces-redirect=true";
    }

    public String newSubscription() {
        this.subscription = new Subscription();
        this.recipient = new Recipient();
        return "subscription-form";
    }

    // ================== SORTING ==================

    public void toggleSort(String column) {
        if (this.sortBy.equals(column)) {
            this.ascending = !this.ascending;
        } else {
            this.sortBy = column;
            this.ascending = true;
        }
        subscriptionList = null;
    }

    // ================== TEST ONLY ==================

    private Recipient getTestRecipient() {
        Recipient r = new Recipient();
        r.sethId("R001");
        r.setFirstName("Amit");
        r.setLastName("Sharma");
        r.setGender("MALE");
        r.setDob(java.sql.Date.valueOf("1990-04-15"));
        r.setMobile("9876543210");
        r.setEmail("amit@example.com");
        return r;
    }
}
