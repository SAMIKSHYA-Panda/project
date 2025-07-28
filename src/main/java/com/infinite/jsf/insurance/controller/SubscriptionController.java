package com.infinite.jsf.insurance.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.*;
import com.infinite.jsf.insurance.daoImpl.*;
import com.infinite.jsf.insurance.model.*;
import com.infinite.jsf.util.SessionHelper;
import com.infinite.jsf.util.SubscriptionIdGenerator;

/**
 * SubscriptionController.java
 *
 * This is a JSF Managed Bean Controller that handles operations related to 
 * individual and family insurance subscriptions in the insurance system.
 * 
 * Responsibilities:
 * - Handles navigation between plan exploration, subscription forms, and success pages.
 * - Manages subscription creation, retrieval, deletion, and renewal.
 * - Supports both individual and family insurance plan workflows.
 * - Uses Hibernate 3.6 (XML-based configuration) for database operations.
 * - Fetches data related to Recipient, InsurancePlan, InsuranceCoverageOption, and SubscribedMember.
 * - Integrates with DAO layer to perform CRUD operations.
 * - Provides sorting and filtering capabilities for subscription listings.
 *
 * Technologies Used:
 * - JSF 2 (backed by JSP pages)
 * - Hibernate 3.6 (no annotations)
 * - Java EE (FacesContext, Managed Beans, etc.)
 *
 * Author: [Samikshya Panda]
 * Date: [26-07-2025]
 */
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
    /**
     * Navigates to the plan exploration page.
     * @return navigation string to ExplorePlans2.jsp
     */
    public String navigateToPlans() {
        return "ExplorePlans2";
    }
    /**
     * Prepares the subscription form for the selected insurance plan.
     * If the plan is a family type, redirects to the family subscription page.
     * @param plan the selected insurance plan
     * @return navigation string to subscription form
     */
    public String prepareSubscriptionPage(InsurancePlan plan) {
        this.selectedPlan = plan;
        this.coverageOptions = coverageDao.getOptionsByPlanId(plan.getPlanId());
        this.recipient = new Recipient();

        if ("FAMILY".equalsIgnoreCase(plan.getPlanType().name())) {
            this.familyMembers = new ArrayList<>();
            return "family-subscription";  // << navigates to family-subscription.jsp
        }

        return "Subscribe";  // << navigates to Subscribe.jsp
    }

    // ================== BUSINESS LOGIC ==================
    /**
     * Fetches recipient details from the database using their HID.
     * If the recipient does not exist, a warning message is added.
     */
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
    /**
     * Saves an individual subscription after verifying recipient and selected coverage.
     * Calculates expiry date as one year from today.
     * @return navigation string upon success or null on failure
     */
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

            return "subscription_successful?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while saving subscription.", null));
            return null;
        }
    }

    // ================== CRUD SUPPORT ==================
    /**
     * Sets the current subscription and recipient objects for editing.
     * @param sub the subscription to be edited
     * @return navigation string to subscription form
     */
    public String editSubscription(Subscription sub) {
        this.subscription = sub;
        this.recipient = sub.getRecipient();
        return "subscription-form";
    }
    /**
     * Deletes a subscription using its ID and refreshes the subscription list.
     * @param sub the subscription to delete
     * @return navigation string to subscription list page
     */
    public String deleteSubscription(Subscription sub) {
        subscriptionDao.deleteSubscription(sub.getSubscriptionId());
        subscriptionList = null;
        return "SubscriptionList?faces-redirect=true";
    }
    /**
     * Renews a subscription by extending its expiry date by one year from today.
     * @param subscriptionId ID of the subscription to renew
     * @return navigation string to refreshed subscription list
     */
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
    /**
     * Initializes a new subscription and recipient for fresh entry.
     * @return navigation string to subscription form
     */
    public String newSubscription() {
        this.subscription = new Subscription();
        this.recipient = new Recipient();
        return "subscription-form";
    }

    // ================== SORTING ==================
    /**
     * Toggles the sorting order and field for the subscription list.
     * @param column the column name to sort by
     */
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

private List<SubscribedMember> familyMembers = new ArrayList<SubscribedMember>();
private SubscribedMemberDao subscribedMemberDao = new SubscribedMemberDaoImpl();
/**
 * Prepares family subscription page for the given insurance plan.
 * Validates whether the plan is a FAMILY type.
 * @param plan the selected insurance plan
 * @return navigation string to family-subscription page
 */
// Family subscription specific methods
public String prepareFamilySubscription(InsurancePlan plan) {
    this.selectedPlan = plan;
    if (!"FAMILY".equals(plan.getPlanType().name())) {
        FacesMessage message = new FacesMessage("Selected plan is not a family plan");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null;
    }
    this.coverageOptions = coverageDao.getOptionsByPlanId(plan.getPlanId());
    this.recipient = new Recipient();
    this.familyMembers = new ArrayList<SubscribedMember>(); // Reset family members
    return "family-subscription";
}
/**
 * Adds a new empty family member row to the familyMembers list.
 * Restricts the total number of family members to 4.
 */
public void addFamilyMember() {
	    if (this.familyMembers.size() < 4) {
	        this.familyMembers.add(new SubscribedMember());
	    } else {
	        FacesContext.getCurrentInstance().addMessage(null,
	            new FacesMessage(FacesMessage.SEVERITY_WARN, "Maximum 4 family members allowed.", null));
	    }
	}
/**
 * Removes a selected family member from the list.
 * @param member the family member to remove
 */
public void removeFamilyMember(SubscribedMember member) {
    this.familyMembers.remove(member);
}
/**
 * Saves a family subscription along with associated subscribed family members.
 * Verifies proposer and all family member HIDs before saving.
 * @return navigation string to subscription list on success, or null on error
 */
public String saveFamilySubscription() {
    Session session = null;
    Transaction tx = null;
    try {
        session = SessionHelper.getSessionFactory().openSession();
        tx = session.beginTransaction();

        // 1. Verify and load proposer
        Recipient proposer = (Recipient) session.get(Recipient.class, recipient.gethId());
        if (proposer == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proposer not found!", null));
            return null;
        }

        // 2. Create and save subscription
        Subscription subscription = new Subscription();
        subscription.setSubscriptionId(subscriptionDao.generateNextSubscriptionId());
        subscription.setRecipient(proposer);
        System.err.println("Subscription Id : " + subscription.getSubscriptionId());
        InsuranceCoverageOption coverage = (InsuranceCoverageOption) session.get(
            InsuranceCoverageOption.class, selectedCoverageId);
        subscription.setInsurancecoverageOption(coverage);
        
        // Calculate premium (base * (1 + family members))
        double basePremium = coverage.getPremiumAmount();
        subscription.setTotalPremium(basePremium * (1 + familyMembers.size()));
        
        subscription.setSubscribeDate(new Date());
        subscription.setExpiryDate(calculateOneYearLater());
        subscription.setStatus("Active");
        session.save(subscription);

        // 3. Save all family members
        for (SubscribedMember member : familyMembers) {
            // Verify each family member exists
            Recipient familyRecipient = (Recipient) session.get(Recipient.class, member.gethId());
            if (familyRecipient == null) {
                throw new Exception("Family member not found: " + member.gethId());
            }
            
            member.setMemberId(SubscriptionIdGenerator.getNextMemberId(session)); // Simple ID generation
            member.setSubscriptionId(subscription.getSubscriptionId());
            member.setSubscription(subscription);
            member.setFullName(familyRecipient.getFirstName() + " " + familyRecipient.getLastName());
            member.setDob(familyRecipient.getDob());
            member.setGender(familyRecipient.getGender());
            System.err.println("Member : " + member.getFullName());
            
            session.save(member);
        }
       
//        System.err.println("Members  : " + familyMembers);
        System.err.println("Complete Subscription : " + subscription);
        tx.commit();
        
        // Reset form
        this.subscription = new Subscription();
        this.recipient = new Recipient();
        this.familyMembers = new ArrayList<SubscribedMember>();
        this.subscriptionList = null;
        
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage("Family subscription created successfully!"));
        return "subscription_successful?faces-redirect=true";

    } catch (Exception e) {
        if (tx != null) tx.rollback();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: " + e.getMessage(), null));
        return null;
    } finally {
        if (session != null) session.close();
    }
}
/**
 * Calculates a date exactly one year from today.
 * @return Date object representing the new expiry date
 */
private Date calculateOneYearLater() {
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, 1);
    return cal.getTime();
}

// Getters and setters for familyMembers
public List<SubscribedMember> getFamilyMembers() {
    return familyMembers;
}

public void setFamilyMembers(List<SubscribedMember> familyMembers) {
    this.familyMembers = familyMembers;
}/**
 * Fetches details for a subscribed family member based on their HID.
 * Populates full name, gender, and DOB from the Recipient table.
 * @param member the family member whose data is to be fetched
 */
public void fetchFamilyMemberDetails(SubscribedMember member) {
    Session session = null;
    try {
        session = SessionHelper.getSessionFactory().openSession();
        Recipient r = (Recipient) session.get(Recipient.class, member.gethId());
        if (r != null) {
            member.setFullName(r.getFirstName() + " " + r.getLastName());
            member.setDob(r.getDob());
            member.setGender(r.getGender());
            member.setRecipient(r); 
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN, "Member HID not found: " + member.gethId(), null));
        }
    } catch (Exception e) {
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error fetching member details!", null));
    } finally {
        if (session != null) session.close();
    }
}


}
